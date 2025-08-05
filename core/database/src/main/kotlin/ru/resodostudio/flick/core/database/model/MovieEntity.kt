package ru.resodostudio.flick.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.resodostudio.flick.core.model.Movie

@Entity(
    tableName = "movies",
)
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
)

fun MovieEntity.asExternalModel(): Movie {
    return Movie(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}
