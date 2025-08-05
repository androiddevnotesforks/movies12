package ru.resodostudio.core.data.repository

import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.model.SearchMovie

interface SearchRepository {

    fun searchMovies(query: String): Flow<List<SearchMovie>>
}