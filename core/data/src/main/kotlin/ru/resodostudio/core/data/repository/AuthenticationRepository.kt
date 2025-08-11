package ru.resodostudio.core.data.repository

interface AuthenticationRepository {

    suspend fun getRequestToken()

    fun createSession()
}