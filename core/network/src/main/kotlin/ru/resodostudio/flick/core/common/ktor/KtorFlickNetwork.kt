package ru.resodostudio.flick.core.common.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.core.common.FlickNetworkDataSource
import ru.resodostudio.flick.core.common.model.NetworkCastCredits
import ru.resodostudio.flick.core.common.model.NetworkCrewCredits
import ru.resodostudio.flick.core.common.model.NetworkImageExtended
import ru.resodostudio.flick.core.common.model.NetworkMovie
import ru.resodostudio.flick.core.common.model.NetworkPerson
import ru.resodostudio.flick.core.common.model.NetworkSearchMovie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorFlickNetwork @Inject constructor(
    private val httpClient: HttpClient,
) : FlickNetworkDataSource {

    override suspend fun getMovies(): List<NetworkMovie> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(id: Int): NetworkMovie {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieImages(id: Int): List<NetworkImageExtended> {
        TODO("Not yet implemented")
    }

    override suspend fun getPeople(): List<NetworkPerson> {
        return httpClient
            .get("person/popular")
            .body<NetworkResult<List<NetworkPerson>>>()
            .results
    }

    override suspend fun getPerson(id: Int): NetworkPerson {
        TODO("Not yet implemented")
    }

    override suspend fun searchMovies(query: String): List<NetworkSearchMovie> {
        TODO("Not yet implemented")
    }

    override suspend fun getCastCredits(id: Int): List<NetworkCastCredits> {
        TODO("Not yet implemented")
    }

    override suspend fun getCrewCredits(id: Int): List<NetworkCrewCredits> {
        TODO("Not yet implemented")
    }
}

@Serializable
private data class NetworkResult<T>(
    val results: T,
)