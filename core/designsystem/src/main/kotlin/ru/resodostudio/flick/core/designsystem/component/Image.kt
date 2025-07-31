package ru.resodostudio.flick.core.designsystem.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import ru.resodostudio.flick.core.designsystem.R

@Composable
fun FlickAsyncImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .error(if (isSystemInDarkTheme()) R.drawable.ic_outlined_face_white else R.drawable.ic_outlined_face)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier,
    )
}

@Composable
fun FlickSubcomposeAsyncImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier,
        loading = { AnimatedShimmer() },
        contentScale = contentScale,
    )
}