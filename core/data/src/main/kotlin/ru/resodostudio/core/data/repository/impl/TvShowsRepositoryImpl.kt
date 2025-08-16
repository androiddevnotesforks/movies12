package ru.resodostudio.core.data.repository.impl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.resodostudio.core.data.paging.TvShowsRemoteMediator
import ru.resodostudio.core.data.repository.TvShowsRepository
import ru.resodostudio.flick.core.database.dao.TvShowsDao
import ru.resodostudio.flick.core.database.model.asExternalModel
import ru.resodostudio.flick.core.model.TvShow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class TvShowsRepositoryImpl @Inject constructor(
    private val tvShowsDao: TvShowsDao,
    private val tvShowsRemoteMediator: TvShowsRemoteMediator,
) : TvShowsRepository {

    override fun getTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = tvShowsRemoteMediator,
            pagingSourceFactory = { tvShowsDao.getTvShowEntities() }
        ).flow.map { pagingData ->
            pagingData.map { it.asExternalModel() }
        }
    }
}