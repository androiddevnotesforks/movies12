package ru.resodostudio.flick.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object HomeBaseRoute

@Serializable
data object HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HomeBaseRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<HomeBaseRoute>(
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {

        }
        nestedGraphs()
    }
}