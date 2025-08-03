package ru.resodostudio.flick.core.model

data class MovieExtended(
    val movie: Movie,
    val images: List<ImageExtended>,
    val isFavorite: Boolean
)