package ru.resodostudio.flick.feature.people.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.feature.people.PeopleRoute

@Serializable
data object PeopleBaseRoute

@Serializable
data object PeopleRoute

fun NavController.navigateToPeople(navOptions: NavOptions? = null) {
    this.navigate(PeopleBaseRoute, navOptions)
}

fun NavGraphBuilder.peopleScreen(
    onPersonClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<PeopleBaseRoute>(
        startDestination = PeopleRoute,
    ) {
        composable<PeopleRoute> {
            PeopleRoute(onPersonClick = onPersonClick)
        }
        nestedGraphs()
    }
}