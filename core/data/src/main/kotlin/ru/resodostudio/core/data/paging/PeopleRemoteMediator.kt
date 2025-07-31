package ru.resodostudio.core.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kotlinx.coroutines.flow.first
import ru.resodostudio.core.data.model.asEntity
import ru.resodostudio.flick.core.database.dao.PeopleDao
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao
import ru.resodostudio.flick.core.database.model.PersonEntity
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PeopleRemoteMediator @Inject constructor(
    private val network: FlickNetworkDataSource,
    private val peopleDao: PeopleDao,
    private val remoteKeysDao: RemoteKeysDao,
) : RemoteMediator<Int, PersonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PersonEntity>,
    ): MediatorResult {
        return runCatching {
            val query = "person/popular"
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

            val networkPeople = network.getPeople(
                page = loadKey,
            )

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteRemoteKey(query)
            }

            val nextKey = (networkPeople.page + 1).coerceIn(1, 500)

            remoteKeysDao.upsertRemoteKey(
                RemoteKeyEntity(
                    query = query,
                    nextPageKey = nextKey,
                )
            )

            val peopleEntities = networkPeople.results.map { it.asEntity() }
            peopleDao.upsertPeople(peopleEntities)

            MediatorResult.Success(endOfPaginationReached = nextKey == 500)
        }.getOrElse { MediatorResult.Error(it) }
    }
}