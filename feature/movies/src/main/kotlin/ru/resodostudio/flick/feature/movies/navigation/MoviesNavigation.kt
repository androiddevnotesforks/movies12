package ru.resodostudio.flick.feature.movies.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.feature.movies.MoviesRoute

@Serializable
data object MoviesBaseRoute

@Serializable
data object MoviesRoute

fun NavController.navigateToMovies(navOptions: NavOptions? = null) {
    this.navigate(MoviesBaseRoute, navOptions)
}

fun NavGraphBuilder.moviesScreen(
    onMovieClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<MoviesBaseRoute>(
        startDestination = MoviesRoute,
    ) {
        composable<MoviesRoute> {
            MoviesRoute(onMovieClick = onMovieClick)
        }
        nestedGraphs()
    }
}