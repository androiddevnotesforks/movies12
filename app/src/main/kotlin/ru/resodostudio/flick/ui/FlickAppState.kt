package ru.resodostudio.flick.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.resodostudio.core.data.util.NetworkMonitor
import ru.resodostudio.flick.feature.home.navigation.navigateToHome
import ru.resodostudio.flick.feature.movies.navigation.navigateToMovies
import ru.resodostudio.flick.feature.people.navigation.navigateToPeople
import ru.resodostudio.flick.feature.profile.navigation.navigateToProfile
import ru.resodostudio.flick.feature.tvshows.navigation.navigateToTvShows
import ru.resodostudio.flick.navigation.TopLevelDestination
import ru.resodostudio.flick.navigation.TopLevelDestination.HOME
import ru.resodostudio.flick.navigation.TopLevelDestination.MOVIES
import ru.resodostudio.flick.navigation.TopLevelDestination.PEOPLE
import ru.resodostudio.flick.navigation.TopLevelDestination.PROFILE
import ru.resodostudio.flick.navigation.TopLevelDestination.TV_SHOWS

@Composable
fun rememberFlickAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
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
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() {
            return TopLevelDestination.entries.firstOrNull { topLevelDestination ->
                currentDestination?.hasRoute(route = topLevelDestination.route) == true
            }
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
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
            when (topLevelDestination) {
                HOME -> navController.navigateToHome(topLevelNavOptions)
                MOVIES -> navController.navigateToMovies(topLevelNavOptions)
                TV_SHOWS -> navController.navigateToTvShows(topLevelNavOptions)
                PEOPLE -> navController.navigateToPeople(topLevelNavOptions)
                PROFILE -> navController.navigateToProfile(topLevelNavOptions)
            }
        }
    }
}