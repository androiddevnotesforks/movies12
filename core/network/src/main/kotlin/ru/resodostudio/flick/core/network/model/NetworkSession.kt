package ru.resodostudio.flick.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSession(
    @SerialName("status_code")
    val statusCode: Int? = null,
    @SerialName("session_id")
    val sessionId: String? = null,
)