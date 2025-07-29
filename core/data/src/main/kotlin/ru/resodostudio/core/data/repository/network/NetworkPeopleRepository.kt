package ru.resodostudio.core.data.repository.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.resodostudio.core.data.repository.PeopleRepository
import ru.resodostudio.flick.core.model.data.Person
import ru.resodostudio.flick.core.common.FlickNetworkDataSource
import ru.resodostudio.flick.core.common.model.asExternalModel
import javax.inject.Inject

class NetworkPeopleRepository @Inject constructor(
    private val network: FlickNetworkDataSource
) : PeopleRepository {

    override fun getPeople(): Flow<List<Person>> = flow {
        emit(
            network
                .getPeople()
                .map { it.asExternalModel() }
        )
    }

    override fun getPerson(id: Int): Flow<Person> = flow {
        emit(
            network.getPerson(id).asExternalModel()
        )
    }
}