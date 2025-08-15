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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.resodostudio.flick.core.ui.LoadingState
import ru.resodostudio.flick.feature.profile.navigation.PROFILE_DEEP_LINK_BASE_PATH
import ru.resodostudio.flick.core.locales.R as localesR

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val profileUiState by viewModel.profileUiState.collectAsStateWithLifecycle()

    ProfileScreen(
        profileUiState = profileUiState,
        onLoginClick = viewModel::getRequestToken,
        clearRequestToken = viewModel::clearRequestToken,
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun ProfileScreen(
    profileUiState: ProfileUiState,
    onLoginClick: () -> Unit = {},
    clearRequestToken: () -> Unit = {},
) {
    when (profileUiState) {
        ProfileUiState.Loading -> LoadingState()
        is ProfileUiState.Success -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                if (profileUiState.isLoggedIn) {
                    Text("You are logged in!")
                } else {

                    Button(
                        onClick = onLoginClick,
                        shapes = ButtonDefaults.shapes(),
                    ) {
                        Text(
                            text = stringResource(localesR.string.login),
                        )
                    }
                }
            }

            val context = LocalContext.current
            val toolbarColor = MaterialTheme.colorScheme.background.toArgb()
            LaunchedEffect(profileUiState.requestToken) {
                if (profileUiState.requestToken.isNotEmpty()) {
                    launchCustomChromeTab(
                        context = context,
                        uri = "https://www.themoviedb.org/authenticate/${profileUiState.requestToken}?redirect_to=$PROFILE_DEEP_LINK_BASE_PATH".toUri(),
                        toolbarColor = toolbarColor,
                    )
                    clearRequestToken()
                }
            }
        }

        ProfileUiState.Error -> LoadingState()
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