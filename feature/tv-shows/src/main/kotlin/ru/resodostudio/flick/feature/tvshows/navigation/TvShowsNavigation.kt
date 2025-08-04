package ru.resodostudio.flick.feature.tvshows.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.resodostudio.flick.feature.tvshows.MoviesRoute

const val TV_SHOWS_GRAPH_ROUTE_PATTERN = "tv_shows_graph"
const val TV_SHOWS_ROUTE = "movies_route"

fun NavController.navigateToTvShowsGraph(navOptions: NavOptions? = null) {
    this.navigate(TV_SHOWS_GRAPH_ROUTE_PATTERN, navOptions)
}

fun NavGraphBuilder.tvShowsGraph(
    onTvShowClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = TV_SHOWS_GRAPH_ROUTE_PATTERN,
        startDestination = TV_SHOWS_ROUTE,
    ) {
        composable(route = TV_SHOWS_ROUTE) {

        }
        nestedGraphs()
    }
}