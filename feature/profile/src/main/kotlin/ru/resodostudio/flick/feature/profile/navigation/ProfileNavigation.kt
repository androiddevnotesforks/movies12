package ru.resodostudio.flick.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.core.common.util.Constants.DEEP_LINK_SCHEME_AND_HOST
import ru.resodostudio.flick.core.common.util.Constants.PROFILE_PATH
import ru.resodostudio.flick.core.common.util.Constants.REQUEST_TOKEN
import ru.resodostudio.flick.feature.profile.ProfileScreen

@Serializable
data object ProfileBaseRoute

@Serializable
data class ProfileRoute(
    val requestToken: String? = null,
)

private const val PROFILE_DEEP_LINK_BASE_PATH = "$DEEP_LINK_SCHEME_AND_HOST/$PROFILE_PATH/{$REQUEST_TOKEN}"

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(ProfileBaseRoute, navOptions)
}

fun NavGraphBuilder.profileScreen(
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<ProfileBaseRoute>(
        startDestination = ProfileRoute(),
    ) {
        composable<ProfileRoute>(
            deepLinks = listOf(
                navDeepLink<ProfileRoute>(
                    basePath = PROFILE_DEEP_LINK_BASE_PATH,
                )
            ),
        ) {
            ProfileScreen()
        }
        nestedGraphs()
    }
}