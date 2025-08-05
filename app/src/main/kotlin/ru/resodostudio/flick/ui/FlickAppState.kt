package ru.resodostudio.flick.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.resodostudio.core.data.util.NetworkMonitor
import ru.resodostudio.flick.feature.home.navigation.homeRoute
import ru.resodostudio.flick.feature.home.navigation.navigateToHomeGraph
import ru.resodostudio.flick.feature.movies.navigation.moviesRoute
import ru.resodostudio.flick.feature.movies.navigation.navigateToMoviesGraph
import ru.resodostudio.flick.feature.people.navigation.navigateToPeople
import ru.resodostudio.flick.feature.people.navigation.peopleRoute
import ru.resodostudio.flick.feature.settings.navigation.navigateToSettings
import ru.resodostudio.flick.feature.tvshows.navigation.navigateToTvShowsGraph
import ru.resodostudio.flick.navigation.TopLevelDestination
import ru.resodostudio.flick.navigation.TopLevelDestination.HOME
import ru.resodostudio.flick.navigation.TopLevelDestination.MOVIES
import ru.resodostudio.flick.navigation.TopLevelDestination.PEOPLE
import ru.resodostudio.flick.navigation.TopLevelDestination.TV_SHOWS

@Composable
fun rememberFlickAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): FlickAppState {

    return remember(
        navController,
        coroutineScope,
        networkMonitor,
    ) {
        FlickAppState(
            navController,
            coroutineScope,
            networkMonitor,
        )
    }
}

@Stable
class FlickAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> HOME
            moviesRoute -> MOVIES
            peopleRoute -> PEOPLE
            else -> null
        }

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            HOME -> navController.navigateToHomeGraph(topLevelNavOptions)
            MOVIES -> navController.navigateToMoviesGraph(topLevelNavOptions)
            TV_SHOWS -> navController.navigateToTvShowsGraph(topLevelNavOptions)
            PEOPLE -> navController.navigateToPeople(topLevelNavOptions)
        }
    }

    fun navigateToSettings() {
        navController.navigateToSettings()
    }
}