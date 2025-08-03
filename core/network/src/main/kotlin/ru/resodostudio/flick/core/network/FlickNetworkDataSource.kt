package ru.resodostudio.flick.core.network

import ru.resodostudio.flick.core.network.ktor.NetworkPagedResult
import ru.resodostudio.flick.core.network.model.NetworkMovie
import ru.resodostudio.flick.core.network.model.NetworkPerson

interface FlickNetworkDataSource {

    suspend fun getMovies(page: Int): NetworkPagedResult<List<NetworkMovie>>

    suspend fun getPeople(page: Int): NetworkPagedResult<List<NetworkPerson>>

    suspend fun getPerson(id: Int): NetworkPerson
}