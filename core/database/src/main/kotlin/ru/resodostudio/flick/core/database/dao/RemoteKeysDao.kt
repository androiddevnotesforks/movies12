package ru.resodostudio.flick.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity

@Dao
interface RemoteKeysDao {

    @Query("SELECT * FROM remote_keys WHERE `query` = :query")
    fun getRemoteKeyEntity(query: String): Flow<RemoteKeyEntity>

    @Upsert
    suspend fun upsertRemoteKey(remoteKey: RemoteKeyEntity)

    @Query("DELETE FROM remote_keys WHERE `query` = :query")
    suspend fun deleteRemoteKey(query: String)
}