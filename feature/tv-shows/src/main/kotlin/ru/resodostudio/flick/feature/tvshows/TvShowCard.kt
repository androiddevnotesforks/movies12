package ru.resodostudio.flick.feature.tvshows

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.resodostudio.flick.core.designsystem.component.FlickSubcomposeAsyncImage
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons
import ru.resodostudio.flick.core.designsystem.icon.filled.Theaters
import ru.resodostudio.flick.core.model.TvShow

@Composable
internal fun TvShowCard(
    tvShow: TvShow,
    onTvShowClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        onClick = { onTvShowClick(tvShow.id) },
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
            ) {
                FlickSubcomposeAsyncImage(
                    imagePath = tvShow.posterPath,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.667f),
                    size = maxWidth,
                    errorIcon = FlickIcons.Filled.Theaters,
                    shape = MaterialTheme.shapes.large,
                )

                Surface(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(12.dp)),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                ) {
                    Text(
                        text = "%.1f".format(tvShow.voteAverage),
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                bottom = 2.dp,
                            ),
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 1,
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(12.dp),
            ) {
                Text(
                    text = tvShow.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                )

                Text(
                    text = tvShow.firstAirDate.take(4),
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}