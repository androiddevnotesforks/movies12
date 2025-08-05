package ru.resodostudio.flick.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.resodostudio.flick.core.model.TvShow

@Entity(
    tableName = "tv_shows",
)
data class TvShowEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,
    val name: String,
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String>,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
)

fun TvShowEntity.asExternalModel(): TvShow {
    return TvShow(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        firstAirDate = firstAirDate,
        genreIds = genreIds,
        name = name,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalName = originalName,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}
