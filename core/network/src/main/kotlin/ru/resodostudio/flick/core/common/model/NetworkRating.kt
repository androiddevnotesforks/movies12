package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkRating(
    val average: Double = 0.0
)