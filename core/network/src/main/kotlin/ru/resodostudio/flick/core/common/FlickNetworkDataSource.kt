package ru.resodostudio.flick.core.common

import ru.resodostudio.flick.core.common.model.NetworkCastCredits
import ru.resodostudio.flick.core.common.model.NetworkCrewCredits
import ru.resodostudio.flick.core.common.model.NetworkImageExtended
import ru.resodostudio.flick.core.common.model.NetworkMovie
import ru.resodostudio.flick.core.common.model.NetworkPerson
import ru.resodostudio.flick.core.common.model.NetworkSearchMovie

interface FlickNetworkDataSource {

    suspend fun getMovies(): List<NetworkMovie>

    suspend fun getMovie(id: Int): NetworkMovie

    suspend fun getMovieImages(id: Int): List<NetworkImageExtended>

    suspend fun getPeople(): List<NetworkPerson>

    suspend fun getPerson(id: Int): NetworkPerson

    suspend fun searchMovies(query: String): List<NetworkSearchMovie>

    suspend fun getCastCredits(id: Int): List<NetworkCastCredits>

    suspend fun getCrewCredits(id: Int): List<NetworkCrewCredits>
}