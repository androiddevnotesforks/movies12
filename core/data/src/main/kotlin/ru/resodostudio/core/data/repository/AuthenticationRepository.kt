package ru.resodostudio.core.data.repository

interface AuthenticationRepository {

    suspend fun getRequestToken()

    suspend fun createSession(requestToken: String)
}