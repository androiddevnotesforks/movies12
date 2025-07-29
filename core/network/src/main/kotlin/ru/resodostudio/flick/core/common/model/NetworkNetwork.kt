package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkNetwork(
    val country: NetworkCountry = NetworkCountry(),
    val id: Int = 0,
    val name: String = "",
    val officialSite: String = ""
)