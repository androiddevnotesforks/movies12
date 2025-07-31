package ru.resodostudio.flick.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlickTopAppBar(
    @StringRes titleRes: Int,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(titleRes)) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlickLargeTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String?,
    onNavigationClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior
) {
    LargeTopAppBar(
        title = { Text(text = stringResource(titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}