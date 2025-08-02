package ru.resodostudio.core.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kotlinx.coroutines.flow.first
import ru.resodostudio.core.data.model.asEntity
import ru.resodostudio.flick.core.database.dao.MoviesDao
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao
import ru.resodostudio.flick.core.database.model.MovieEntity
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class MoviesRemoteMediator @Inject constructor(
    private val network: FlickNetworkDataSource,
    private val moviesDao: MoviesDao,
    private val remoteKeysDao: RemoteKeysDao,
) : RemoteMediator<Int, MovieEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>,
    ): MediatorResult {
        return runCatching {
            val query = "movie/popular"
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

            val networkMovies = network.getMovies(
                page = loadKey,
            )

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteRemoteKey(query)
            }

            val nextKey = (networkMovies.page + 1).coerceIn(1, 500)

            remoteKeysDao.upsertRemoteKey(
                RemoteKeyEntity(
                    query = query,
                    nextPageKey = nextKey,
                )
            )

            val movieEntities = networkMovies.results.map { it.asEntity() }
            moviesDao.upsertMovies(movieEntities)

            MediatorResult.Success(endOfPaginationReached = nextKey == 500)
        }.getOrElse { MediatorResult.Error(it) }
    }
}