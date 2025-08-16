package ru.resodostudio.core.data.repository.impl

import kotlinx.coroutines.flow.first
import ru.resodostudio.core.data.repository.AuthenticationRepository
import ru.resodostudio.core.data.repository.UserDataRepository
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

    override suspend fun createSession(requestToken: String) {
        val sessionResult = flickNetworkDataSource.createSession(requestToken)
        sessionResult.sessionId?.let { userDataRepository.updateSessionId(it) }
    }

    override suspend fun deleteSession() {
        val sessionId = userDataRepository.userData.first().sessionId
        flickNetworkDataSource.deleteSession(sessionId)
        userDataRepository.updateSessionId("")
    }
}