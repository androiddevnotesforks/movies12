package ru.resodostudio.flick.core.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.core.model.data.KnownFor
import ru.resodostudio.flick.core.model.data.Person

@Serializable
data class NetworkPerson(
    val adult: Boolean? = null,
    val gender: Int? = null,
    val id: Int? = null,
    @SerialName("known_for")
    val knownFor: List<NetworkKnownFor>? = null,
    @SerialName("known_for_department")
    val knownForDepartment: String? = null,
    val name: String? = null,
    @SerialName("original_name")
    val originalName: String? = null,
    val popularity: Double? = null,
    @SerialName("profile_path")
    val profilePath: String? = null,
)

fun NetworkPerson.asExternalModel() = Person(
    adult = adult ?: false,
    gender = gender ?: -1,
    id = id ?: -1,
    knownFor = knownFor?.map {
        KnownFor(
            adult = it.adult,
            backdropPath = it.backdropPath,
            firstAirDate = it.firstAirDate,
            genreIds = it.genreIds,
            id = it.id,
            mediaType = it.mediaType,
            name = it.name,
            originCountry = it.originCountry,
            originalLanguage = it.originalLanguage,
            originalName = it.originalName,
            originalTitle = it.originalTitle,
            overview = it.overview,
            popularity = it.popularity,
            posterPath = it.posterPath,
            releaseDate = it.releaseDate,
            title = it.title,
            video = it.video,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount
        )
    } ?: emptyList(),
    knownForDepartment = knownForDepartment.toString(),
    name = name.toString(),
    originalName = originalName.toString(),
    popularity = popularity ?: 0.0,
    profilePath = profilePath.toString(),
)