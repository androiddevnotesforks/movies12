package ru.resodostudio.flick.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import ru.resodostudio.flick.feature.home.navigation.HomeBaseRoute
import ru.resodostudio.flick.feature.home.navigation.homeScreen
import ru.resodostudio.flick.feature.movie.navigation.movieScreen
import ru.resodostudio.flick.feature.movie.navigation.navigateToMovie
import ru.resodostudio.flick.feature.movies.navigation.moviesScreen
import ru.resodostudio.flick.feature.people.navigation.peopleScreen
import ru.resodostudio.flick.feature.person.navigation.navigateToPerson
import ru.resodostudio.flick.feature.person.navigation.personScreen
import ru.resodostudio.flick.feature.profile.navigation.profileScreen
import ru.resodostudio.flick.feature.tvshows.navigation.tvShowsScreen
import ru.resodostudio.flick.ui.FlickAppState

@Composable
fun FlickNavHost(
    appState: FlickAppState,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeBaseRoute,
    ) {
        homeScreen(
            nestedGraphs = {

            },
        )
        moviesScreen(
            onMovieClick = { movieId ->
                navController.navigateToMovie(movieId)
            },
            nestedGraphs = {
                movieScreen(
                    onBackClick = navController::popBackStack,
                    onPersonClick = { personId ->
                        navController.navigateToPerson(personId)
                    },
                )
            },
        )
        tvShowsScreen(
            onTvShowClick = { tvShowId ->

            },
            nestedGraphs = {

            },
        )
        peopleScreen(
            onPersonClick = { personId ->
                navController.navigateToPerson(personId)
            },
            nestedGraphs = {
                personScreen(
                    onBackClick = navController::popBackStack,
                    onMovieClick = { movieId ->
                        navController.navigateToMovie(movieId)
                    },
                )
            },
        )
        profileScreen(
            nestedGraphs = {

            },
        )
    }
}