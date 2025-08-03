package ru.resodostudio.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.resodostudio.core.data.paging.MoviesRemoteMediator
import ru.resodostudio.flick.core.database.dao.MoviesDao
import ru.resodostudio.flick.core.database.model.asExternalModel
import ru.resodostudio.flick.core.model.Movie
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class MoviesRepositoryImpl @Inject constructor(
    private val moviesDao: MoviesDao,
    private val moviesRemoteMediator: MoviesRemoteMediator,
) : MoviesRepository {

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = moviesRemoteMediator,
            pagingSourceFactory = { moviesDao.getMovieEntities() }
        ).flow.map { pagingData ->
            pagingData.map { it.asExternalModel() }
        }
    }
}