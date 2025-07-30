package ru.resodostudio.flick.core.network

import ru.resodostudio.flick.core.network.model.NetworkPerson

interface FlickNetworkDataSource {

    suspend fun getPeople(page: Int): List<NetworkPerson>

    suspend fun getPerson(id: Int): NetworkPerson
}