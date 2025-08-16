package ru.resodostudio.flick.core.network

import ru.resodostudio.flick.core.network.model.NetworkMovie
import ru.resodostudio.flick.core.network.model.NetworkPagedResult
import ru.resodostudio.flick.core.network.model.NetworkPerson
import ru.resodostudio.flick.core.network.model.NetworkRequestToken
import ru.resodostudio.flick.core.network.model.NetworkSession
import ru.resodostudio.flick.core.network.model.NetworkTvShow

interface FlickNetworkDataSource {

    suspend fun createRequestToken(): NetworkRequestToken

    suspend fun createSession(requestToken: String): NetworkSession

    suspend fun deleteSession(sessionId: String)

    suspend fun getMovies(page: Int): NetworkPagedResult<List<NetworkMovie>>

    suspend fun getPeople(page: Int): NetworkPagedResult<List<NetworkPerson>>

    suspend fun getPerson(id: Int): NetworkPerson

    suspend fun getTvShows(page: Int): NetworkPagedResult<List<NetworkTvShow>>
}