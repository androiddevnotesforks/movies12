package ru.resodostudio.flick.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.resodostudio.flick.core.database.dao.PeopleDao
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao
import ru.resodostudio.flick.core.database.model.PersonEntity
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity

@Database(
    entities = [
        RemoteKeyEntity::class,
        PersonEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class FlickDatabase : RoomDatabase() {

    abstract fun remoteKeysDao(): RemoteKeysDao

    abstract fun peopleDao(): PeopleDao
}