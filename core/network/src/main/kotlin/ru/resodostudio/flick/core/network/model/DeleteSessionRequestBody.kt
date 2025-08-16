package ru.resodostudio.flick.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeleteSessionRequestBody(
    @SerialName("session_id")
    val sessionId: String,
)
