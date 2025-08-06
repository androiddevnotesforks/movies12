package ru.resodostudio.flick.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ru.resodostudio.flick.core.designsystem.icon.FlickIcons
import ru.resodostudio.flick.core.designsystem.icon.filled.AccountCircle
import ru.resodostudio.flick.core.designsystem.icon.filled.Face
import ru.resodostudio.flick.core.designsystem.icon.filled.Home
import ru.resodostudio.flick.core.designsystem.icon.filled.LiveTv
import ru.resodostudio.flick.core.designsystem.icon.filled.Theaters
import ru.resodostudio.flick.core.designsystem.icon.rounded.AccountCircle
import ru.resodostudio.flick.core.designsystem.icon.rounded.Face
import ru.resodostudio.flick.core.designsystem.icon.rounded.Home
import ru.resodostudio.flick.core.designsystem.icon.rounded.LiveTv
import ru.resodostudio.flick.core.designsystem.icon.rounded.Theaters
import ru.resodostudio.flick.core.locales.R as localesR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = FlickIcons.Filled.Home,
        unselectedIcon = FlickIcons.Rounded.Home,
        iconTextId = localesR.string.home,
        titleTextId = localesR.string.app_name,
    ),
    MOVIES(
        selectedIcon = FlickIcons.Filled.Theaters,
        unselectedIcon = FlickIcons.Rounded.Theaters,
        iconTextId = localesR.string.movies,
        titleTextId = localesR.string.movies,
    ),
    TV_SHOWS(
        selectedIcon = FlickIcons.Filled.LiveTv,
        unselectedIcon = FlickIcons.Rounded.LiveTv,
        iconTextId = localesR.string.tv_shows,
        titleTextId = localesR.string.tv_shows,
    ),
    PEOPLE(
        selectedIcon = FlickIcons.Filled.Face,
        unselectedIcon = FlickIcons.Rounded.Face,
        iconTextId = localesR.string.people,
        titleTextId = localesR.string.people,
    ),
    PROFILE(
        selectedIcon = FlickIcons.Filled.AccountCircle,
        unselectedIcon = FlickIcons.Rounded.AccountCircle,
        iconTextId = localesR.string.profile,
        titleTextId = localesR.string.profile,
    ),
}