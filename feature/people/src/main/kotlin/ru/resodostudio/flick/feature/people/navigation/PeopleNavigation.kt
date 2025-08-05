package ru.resodostudio.flick.feature.people.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.resodostudio.flick.feature.people.PeopleRoute

const val PEOPLE_GRAPH_ROUTE_PATTERN = "people_graph"
const val PEOPLE_ROUTE = "people_route"

fun NavController.navigateToPeople(navOptions: NavOptions? = null) {
    this.navigate(PEOPLE_ROUTE, navOptions)
}

fun NavGraphBuilder.peopleGraph(
    onPersonClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = PEOPLE_GRAPH_ROUTE_PATTERN,
        startDestination = PEOPLE_ROUTE,
    ) {
        composable(route = PEOPLE_ROUTE) {
            PeopleRoute(onPersonClick = onPersonClick)
        }
        nestedGraphs()
    }
}