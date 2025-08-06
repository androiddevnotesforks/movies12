package ru.resodostudio.flick.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val PROFILE_GRAPH_ROUTE_PATTERN = "profile_graph"
const val PROFILE_ROUTE = "profile_route"

fun NavController.navigateToProfileGraph(navOptions: NavOptions? = null) {
    this.navigate(PROFILE_GRAPH_ROUTE_PATTERN, navOptions)
}

fun NavGraphBuilder.profileGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = PROFILE_GRAPH_ROUTE_PATTERN,
        startDestination = PROFILE_ROUTE,
    ) {
        composable(route = PROFILE_ROUTE) {

        }
        nestedGraphs()
    }
}