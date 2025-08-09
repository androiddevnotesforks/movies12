package ru.resodostudio.flick.feature.tvshows.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.feature.tvshows.TvShowsRoute

@Serializable
data object TvShowsBaseRoute

@Serializable
data object TvShowsRoute

fun NavController.navigateToTvShows(navOptions: NavOptions? = null) {
    this.navigate(TvShowsBaseRoute, navOptions)
}

fun NavGraphBuilder.tvShowsScreen(
    onTvShowClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<TvShowsBaseRoute>(
        startDestination = TvShowsRoute,
    ) {
        composable<TvShowsRoute> {
            TvShowsRoute(
                onTvShowClick = onTvShowClick,
            )
        }
        nestedGraphs()
    }
}