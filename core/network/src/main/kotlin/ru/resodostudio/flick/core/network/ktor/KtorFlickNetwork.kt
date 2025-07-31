package ru.resodostudio.flick.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import kotlinx.serialization.Serializable
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import ru.resodostudio.flick.core.network.model.NetworkPerson
import ru.resodostudio.flick.core.network.resource.PersonResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KtorFlickNetwork @Inject constructor(
    private val httpClient: HttpClient,
) : FlickNetworkDataSource {

    override suspend fun getPeople(page: Int): NetworkResult<List<NetworkPerson>> {
        return httpClient
            .get(PersonResource.Popular(page = page))
            .body<NetworkResult<List<NetworkPerson>>>()
    }

    override suspend fun getPerson(id: Int): NetworkPerson {
        TODO("Not yet implemented")
    }
}

@Serializable
data class NetworkResult<T>(
    val page: Int,
    val results: T,
)