package ru.resodostudio.core.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.model.Person

interface PeopleRepository {

    fun getPeople(): Flow<PagingData<Person>>

    fun getPerson(id: Int): Flow<Person>
}