package ru.resodostudio.flick.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.database.model.PersonEntity

@Dao
interface PeopleDao {

    @Query("SELECT * FROM people ORDER BY popularity DESC")
    fun getPersonEntities(): PagingSource<Int, PersonEntity>

    @Query("SELECT * FROM people WHERE id = :id")
    fun getPersonEntity(id: Int): Flow<PersonEntity>

    @Upsert
    suspend fun upsertPeople(people: List<PersonEntity>)

    @Query("DELETE FROM people")
    suspend fun deletePeople()
}