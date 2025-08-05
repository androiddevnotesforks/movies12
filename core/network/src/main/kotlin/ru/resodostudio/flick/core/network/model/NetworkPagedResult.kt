package ru.resodostudio.flick.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPagedResult<T>(
    val page: Int,
    val results: T,
)