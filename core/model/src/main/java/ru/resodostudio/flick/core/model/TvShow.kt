package ru.resodostudio.flick.core.model

data class TvShow(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
)
