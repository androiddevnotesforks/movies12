package ru.resodostudio.core.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kotlinx.coroutines.flow.first
import ru.resodostudio.core.data.model.asEntity
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao
import ru.resodostudio.flick.core.database.dao.TvShowsDao
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity
import ru.resodostudio.flick.core.database.model.TvShowEntity
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class TvShowsRemoteMediator @Inject constructor(
    private val network: FlickNetworkDataSource,
    private val tvShowsDao: TvShowsDao,
    private val remoteKeysDao: RemoteKeysDao,
) : RemoteMediator<Int, TvShowEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TvShowEntity>,
    ): MediatorResult {
        return runCatching {
            val query = "tv/popular"
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val nextPageKey = remoteKeysDao.getRemoteKeyEntity(query).first().nextPageKey
                    if (nextPageKey == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    nextPageKey
                }
            }

            val networkTvShows = network.getTvShows(
                page = loadKey,
            )

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteRemoteKey(query)
            }

            val nextKey = (networkTvShows.page + 1).coerceIn(1, 500)

            remoteKeysDao.upsertRemoteKey(
                RemoteKeyEntity(
                    query = query,
                    nextPageKey = nextKey,
                )
            )

            val tvShowEntities = networkTvShows.results.map { it.asEntity() }
            tvShowsDao.upsertTvShows(tvShowEntities)

            MediatorResult.Success(endOfPaginationReached = nextKey == 500)
        }.getOrElse { MediatorResult.Error(it) }
    }
}