package ru.resodostudio.flick.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import ru.resodostudio.flick.core.network.model.NetworkMovie
import ru.resodostudio.flick.core.network.model.NetworkPagedResult
import ru.resodostudio.flick.core.network.model.NetworkPerson
import ru.resodostudio.flick.core.network.resource.MovieResource
import ru.resodostudio.flick.core.network.resource.PersonResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorFlickNetwork @Inject constructor(
    private val httpClient: HttpClient,
) : FlickNetworkDataSource {

    override suspend fun getMovies(page: Int): NetworkPagedResult<List<NetworkMovie>> {
        return httpClient
            .get(MovieResource.Popular(page = page))
            .body<NetworkPagedResult<List<NetworkMovie>>>()
    }

    override suspend fun getPeople(page: Int): NetworkPagedResult<List<NetworkPerson>> {
        return httpClient
            .get(PersonResource.Popular(page = page))
            .body<NetworkPagedResult<List<NetworkPerson>>>()
    }

    override suspend fun getPerson(id: Int): NetworkPerson {
        TODO("Not yet implemented")
    }
}