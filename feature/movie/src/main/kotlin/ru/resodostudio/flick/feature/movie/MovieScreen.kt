package ru.resodostudio.flick.feature.movie

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.resodostudio.flick.core.common.util.formatDate
import ru.resodostudio.flick.core.designsystem.component.FlickAsyncImage
import ru.resodostudio.flick.core.model.data.Movie
import ru.resodostudio.flick.core.model.data.MovieExtended
import ru.resodostudio.flick.core.ui.EmptyState
import ru.resodostudio.flick.core.ui.LoadingState
import ru.resodostudio.flick.core.ui.R.raw.anim_error_2

@Composable
internal fun MovieRoute(
    movieViewModel: MovieViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onPersonClick: (Int) -> Unit
) {
    val movieState by movieViewModel.movieUiState.collectAsStateWithLifecycle()

    MovieScreen(
        movieState = movieState,
        onBackClick = onBackClick,
        onPersonClick = onPersonClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MovieScreen(
    movieState: MovieUiState,
    onBackClick: () -> Unit,
    onPersonClick: (Int) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    when (movieState) {
        MovieUiState.Loading -> LoadingState()
        is MovieUiState.Success -> {
            Scaffold(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                contentWindowInsets = WindowInsets.waterfall,
                content = {
                    LazyColumn(
                        contentPadding = it,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
                            item {
                                MovieHeader(movie = movieState.data.movie)
                            }
                            item {
                                MovieBody(
                                    movieExtended = movieState.data,
                                    onPersonClick = onPersonClick
                                )
                            }
                            item { Spacer(modifier = Modifier.height(50.dp)) }
                        }
                    )
                }
            )
        }

        is MovieUiState.Error -> EmptyState(
            message = movieState.errorMessage,
            animationId = anim_error_2
        )
    }
}

@Composable
private fun MovieHeader(movie: Movie) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        FlickAsyncImage(
            url = movie.image.medium,
            contentDescription = null,
            modifier = Modifier
                .size(width = 130.dp, height = 181.dp)
                .clip(RoundedCornerShape(12.dp)),
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = movie.name,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )

            Surface(
                modifier = Modifier.clip(RoundedCornerShape(12.dp)),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = movie.rating.average.toString(),
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 2.dp,
                            end = 8.dp,
                            bottom = 2.dp
                        ),
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                if (movie.genres.isNotEmpty()) {
                    Text(
                        text = movie.genres.take(3).joinToString(", "),
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (movie.premiered.isNotBlank()) {
                    Text(
                        text = formatDate(movie.premiered),
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start
                    )
                }

                val countryInfo = listOf(movie.network.country.name, movie.network.country.code)
                if (movie.network.country.name.isNotBlank()) {
                    Text(
                        text = countryInfo.joinToString(", "),
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start
                    )
                }

                val statusInfo = listOf(
                    movie.status,
                    "${movie.averageRuntime} ${stringResource(R.string.minutes)}"
                )
                Text(
                    text = statusInfo.joinToString(", "),
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Start
                )

                if (movie.language.isNotBlank()) {
                    Text(
                        text = movie.language,
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    HorizontalDivider()
}

@Composable
private fun MovieBody(
    movieExtended: MovieExtended,
    onPersonClick: (Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.summary),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = HtmlCompat.fromHtml(
                    movieExtended.movie.summary,
                    HtmlCompat.FROM_HTML_MODE_COMPACT
                ).toString(),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (movieExtended.images.isNotEmpty()) {
            val context = LocalContext.current

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.images),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(start = 16.dp)
                )

                LazyHorizontalStaggeredGrid(
                    rows = StaggeredGridCells.Adaptive(150.dp),
                    modifier = Modifier
                        .height(400.dp)
                        .padding(top = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    content = {
                        items(movieExtended.images) { imageExtended ->
                            FlickAsyncImage(
                                url = imageExtended.resolutions.original.url,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .size(
                                        height = convertPixelsToDp(
                                            context = context,
                                            pixels = imageExtended.resolutions.original.height.div(
                                                2f
                                            )
                                        ),
                                        width = convertPixelsToDp(
                                            context = context,
                                            pixels = imageExtended.resolutions.original.width.div(2f)
                                        )
                                    ),
                            )
                        }
                    }
                )
            }
        }
    }
}

fun convertPixelsToDp(context: Context, pixels: Float): Dp {
    val screenPixelDensity = context.resources.displayMetrics.density
    return (pixels / screenPixelDensity).dp
}