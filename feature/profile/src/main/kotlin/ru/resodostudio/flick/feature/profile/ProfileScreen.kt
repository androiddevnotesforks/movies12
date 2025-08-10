package ru.resodostudio.flick.feature.profile

import android.content.Context
import android.net.Uri
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import ru.resodostudio.flick.core.locales.R as localesR

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun ProfileScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        val context = LocalContext.current
        val toolbarColor = MaterialTheme.colorScheme.background.toArgb()
        Button(
            onClick = {
                launchCustomChromeTab(
                    context = context,
                    uri = "".toUri(),
                    toolbarColor = toolbarColor,
                )
            },
            shapes = ButtonDefaults.shapes(),
        ) {
            Text(
                text = stringResource(localesR.string.login),
            )
        }
    }
}

private fun launchCustomChromeTab(
    context: Context,
    uri: Uri,
    @ColorInt toolbarColor: Int,
) {
    val customTabBarColor = CustomTabColorSchemeParams.Builder()
        .setToolbarColor(toolbarColor)
        .build()
    val customTabsIntent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(customTabBarColor)
        .build()
    customTabsIntent.launchUrl(context, uri)
}