package ru.resodostudio.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.resodostudio.core.data.paging.PeopleRemoteMediator
import ru.resodostudio.flick.core.database.dao.PeopleDao
import ru.resodostudio.flick.core.database.model.asExternalModel
import ru.resodostudio.flick.core.model.Person
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class PeopleRepositoryImpl @Inject constructor(
    private val peopleDao: PeopleDao,
    private val peopleRemoteMediator: PeopleRemoteMediator,
) : PeopleRepository {

    override fun getPeople(): Flow<PagingData<Person>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = peopleRemoteMediator,
            pagingSourceFactory = { peopleDao.getPersonEntities() }
        ).flow.map { pagingData ->
            pagingData.map { it.asExternalModel() }
        }
    }

    override fun getPerson(id: Int): Flow<Person> {
        TODO("Not yet implemented")
    }
}