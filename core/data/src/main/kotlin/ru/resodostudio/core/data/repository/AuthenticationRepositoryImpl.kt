package ru.resodostudio.core.data.repository

import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import javax.inject.Inject

internal class AuthenticationRepositoryImpl @Inject constructor(
    private val flickNetworkDataSource: FlickNetworkDataSource,
    private val userDataRepository: UserDataRepository,
) : AuthenticationRepository {

    override suspend fun getRequestToken() {
        val requestToken = flickNetworkDataSource.createRequestToken().requestToken
        userDataRepository.updateRequestToken(requestToken ?: "")
    }

    override fun createSession() {
        TODO("Not yet implemented")
    }
}