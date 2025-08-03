package ru.resodostudio.flick.feature.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.component.FlickSubcomposeAsyncImage
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons
import ru.resodostudio.flick.core.designsystem.icon.filled.Theaters
import ru.resodostudio.flick.core.model.data.Movie

@Composable
internal fun MovieCard(
    movie: Movie,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = { onMovieClick(movie.id) },
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
            ) {
                FlickSubcomposeAsyncImage(
                    imagePath = movie.backdropPath,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    size = maxWidth,
                    errorIcon = FlickIcons.Filled.Theaters,
                    contentScale = ContentScale.Crop,
                )

                Surface(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(12.dp)),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                ) {
                    Text(
                        text = movie.voteAverage.toString().take(4),
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                top = 2.dp,
                                end = 8.dp,
                                bottom = 2.dp,
                            ),
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = movie.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier,
                )

                Text(
                    text = movie.releaseDate,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}