package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkImage(
    val medium: String = "",
    val original: String = ""
)