package ru.resodostudio.flick.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "remote_keys",
)
data class RemoteKeyEntity(
    @PrimaryKey
    val query: String,
    val nextPageKey: Int?,
)