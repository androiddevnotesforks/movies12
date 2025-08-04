package ru.resodostudio.core.data.model

import ru.resodostudio.flick.core.database.model.TvShowEntity
import ru.resodostudio.flick.core.network.model.NetworkTvShow

fun NetworkTvShow.asEntity(): TvShowEntity {
    return TvShowEntity(
        id = id ?: -1,
        adult = adult ?: false,
        backdropPath = backdropPath ?: "",
        originalLanguage = originalLanguage ?: "",
        originalName = originalName ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        posterPath = posterPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
        name = name ?: "",
        firstAirDate = firstAirDate ?: "",
        originCountry = originCountry ?: emptyList(),
        genreIds = genreIds ?: emptyList(),
    )
}