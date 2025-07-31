package ru.resodostudio.flick.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ru.resodostudio.flick.R
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons
import ru.resodostudio.flick.core.designsystem.icon.filled.Face
import ru.resodostudio.flick.core.designsystem.icon.filled.Home
import ru.resodostudio.flick.core.designsystem.icon.filled.LiveTv
import ru.resodostudio.flick.core.designsystem.icon.filled.Theaters
import ru.resodostudio.flick.core.designsystem.icon.rounded.Face
import ru.resodostudio.flick.core.designsystem.icon.rounded.Home
import ru.resodostudio.flick.core.designsystem.icon.rounded.LiveTv
import ru.resodostudio.flick.core.designsystem.icon.rounded.Theaters

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = FlickIcons.Filled.Home,
        unselectedIcon = FlickIcons.Rounded.Home,
        iconTextId = R.string.home,
        titleTextId = R.string.app_name,
    ),
    MOVIES(
        selectedIcon = FlickIcons.Filled.Theaters,
        unselectedIcon = FlickIcons.Rounded.Theaters,
        iconTextId = R.string.movies,
        titleTextId = R.string.movies,
    ),
    TV_SHOWS(
        selectedIcon = FlickIcons.Filled.LiveTv,
        unselectedIcon = FlickIcons.Rounded.LiveTv,
        iconTextId = R.string.tv_shows,
        titleTextId = R.string.tv_shows,
    ),
    PEOPLE(
        selectedIcon = FlickIcons.Filled.Face,
        unselectedIcon = FlickIcons.Rounded.Face,
        iconTextId = R.string.people,
        titleTextId = R.string.people,
    )
}