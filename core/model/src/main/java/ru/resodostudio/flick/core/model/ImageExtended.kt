package ru.resodostudio.flick.core.model

data class ImageExtended(
    val id: Int,
    val main: Boolean,
    val resolutions: Resolutions,
    val type: String
)