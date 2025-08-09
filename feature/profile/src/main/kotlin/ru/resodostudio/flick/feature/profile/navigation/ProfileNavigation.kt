package ru.resodostudio.flick.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object ProfileBaseRoute

@Serializable
data object ProfileRoute

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(ProfileBaseRoute, navOptions)
}

fun NavGraphBuilder.profileScreen(
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<ProfileBaseRoute>(
        startDestination = ProfileRoute,
    ) {
        composable<ProfileRoute> {

        }
        nestedGraphs()
    }
}