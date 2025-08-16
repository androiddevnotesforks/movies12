package ru.resodostudio.flick.core.model

data class UserData(
    val darkThemeConfig: DarkThemeConfig,
    val useDynamicColor: Boolean,
    val sessionId: String,
    val requestToken: String,
)