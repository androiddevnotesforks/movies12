package ru.resodostudio.core.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.model.data.Movie

interface MoviesRepository {

    fun getMovies(): Flow<PagingData<Movie>>
}