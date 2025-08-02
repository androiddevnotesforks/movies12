package ru.resodostudio.core.data.model

import ru.resodostudio.flick.core.database.model.MovieEntity
import ru.resodostudio.flick.core.network.model.NetworkMovie

fun NetworkMovie.asEntity(): MovieEntity {
    return MovieEntity(
        id = id ?: -1,
        adult = adult ?: false,
        backdropPath = backdropPath ?: "",
        genreIds = genreIds ?: emptyList(),
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title ?: "",
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )
}