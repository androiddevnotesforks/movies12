package ru.resodostudio.flick.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import ru.resodostudio.flick.core.network.model.CreateSessionRequestBody
import ru.resodostudio.flick.core.network.model.NetworkMovie
import ru.resodostudio.flick.core.network.model.NetworkPagedResult
import ru.resodostudio.flick.core.network.model.NetworkPerson
import ru.resodostudio.flick.core.network.model.NetworkRequestToken
import ru.resodostudio.flick.core.network.model.NetworkSession
import ru.resodostudio.flick.core.network.model.NetworkTvShow
import ru.resodostudio.flick.core.network.resource.AuthenticationResource
import ru.resodostudio.flick.core.network.resource.MovieResource
import ru.resodostudio.flick.core.network.resource.PersonResource
import ru.resodostudio.flick.core.network.resource.TvShowResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class KtorFlickNetwork @Inject constructor(
    private val httpClient: HttpClient,
) : FlickNetworkDataSource {

    override suspend fun createRequestToken(): NetworkRequestToken {
        return httpClient
            .get(AuthenticationResource.NewToken())
            .body<NetworkRequestToken>()
    }

    override suspend fun createSession(requestToken: String): NetworkSession {
        return httpClient
            .post(AuthenticationResource.NewSession()) {
                setBody(CreateSessionRequestBody(requestToken))
            }
            .body<NetworkSession>()
    }

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

    override suspend fun getTvShows(page: Int): NetworkPagedResult<List<NetworkTvShow>> {
        return httpClient
            .get(TvShowResource.Popular(page = page))
            .body<NetworkPagedResult<List<NetworkTvShow>>>()
    }
}