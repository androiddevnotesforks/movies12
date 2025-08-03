package ru.resodostudio.flick.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkImagesResponse(
    @SerialName("backdrops")
    val backdrops: List<NetworkImage>? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("logos")
    val logos: List<NetworkImage>? = null,
    @SerialName("posters")
    val posters: List<NetworkImage>? = null,
)