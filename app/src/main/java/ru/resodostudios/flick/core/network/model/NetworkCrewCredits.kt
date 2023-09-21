package ru.resodostudios.flick.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.resodostudios.flick.core.model.data.Character
import ru.resodostudios.flick.core.model.data.Country
import ru.resodostudios.flick.core.model.data.CrewCredits
import ru.resodostudios.flick.core.model.data.Embedded
import ru.resodostudios.flick.core.model.data.Image
import ru.resodostudios.flick.core.model.data.Movie
import ru.resodostudios.flick.core.model.data.Network
import ru.resodostudios.flick.core.model.data.Rating

@Serializable
data class NetworkCrewCredits(
    @SerialName(value = "_embedded")
    val embedded: NetworkEmbedded = NetworkEmbedded(),
    val type: String = ""
)

fun NetworkCrewCredits.asExternalModel() = CrewCredits(
    embedded = Embedded(
        character = Character(
            id = embedded.character.id,
            image = Image(
                medium = embedded.character.image.medium,
                original = embedded.character.image.original
            ),
            name = embedded.character.name
        ),
        movie = Movie(
            id = embedded.movie.id,
            name = embedded.movie.name,
            ended = embedded.movie.ended,
            language = embedded.movie.language,
            officialSite = embedded.movie.officialSite,
            premiered = embedded.movie.premiered,
            runtime = embedded.movie.runtime,
            status = embedded.movie.status,
            summary = embedded.movie.summary,
            genres = embedded.movie.genres,
            image = Image(
                medium = embedded.movie.image.medium,
                original = embedded.movie.image.original
            ),
            network = Network(
                country = Country(
                    name = embedded.movie.network.country.name,
                    code = embedded.movie.network.country.code,
                    timezone = embedded.movie.network.country.timezone
                ),
                id = embedded.movie.network.id,
                name = embedded.movie.network.name,
                officialSite = embedded.movie.network.officialSite
            ),
            averageRuntime = embedded.movie.averageRuntime,
            rating = Rating(
                average = embedded.movie.rating.average
            )
        )
    ),
    type = type
)