package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacter(
    val id: Int = -1,
    val image: NetworkImage = NetworkImage(),
    val name: String = ""
)