package ru.resodostudio.flick.core.network

import ru.resodostudio.flick.core.network.ktor.NetworkResult
import ru.resodostudio.flick.core.network.model.NetworkMovie
import ru.resodostudio.flick.core.network.model.NetworkPerson

interface FlickNetworkDataSource {

    suspend fun getMovies(page: Int): NetworkResult<List<NetworkMovie>>

    suspend fun getPeople(page: Int): NetworkResult<List<NetworkPerson>>

    suspend fun getPerson(id: Int): NetworkPerson
}