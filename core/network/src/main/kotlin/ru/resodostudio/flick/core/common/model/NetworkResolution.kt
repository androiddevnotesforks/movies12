package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResolution(
    val height: Int = 0,
    val url: String = "",
    val width: Int = 0
)