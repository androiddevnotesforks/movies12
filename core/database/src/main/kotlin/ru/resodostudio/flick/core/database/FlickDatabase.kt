package ru.resodostudio.flick.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.resodostudio.flick.core.database.dao.MoviesDao
import ru.resodostudio.flick.core.database.dao.PeopleDao
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao
import ru.resodostudio.flick.core.database.dao.TvShowsDao
import ru.resodostudio.flick.core.database.model.MovieEntity
import ru.resodostudio.flick.core.database.model.PersonEntity
import ru.resodostudio.flick.core.database.model.RemoteKeyEntity
import ru.resodostudio.flick.core.database.model.TvShowEntity
import ru.resodostudio.flick.core.database.util.ListIntConverter
import ru.resodostudio.flick.core.database.util.ListStringConverter

@Database(
    entities = [
        RemoteKeyEntity::class,
        PersonEntity::class,
        MovieEntity::class,
        TvShowEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    ListIntConverter::class,
    ListStringConverter::class,
)
abstract class FlickDatabase : RoomDatabase() {

    abstract fun remoteKeysDao(): RemoteKeysDao

    abstract fun peopleDao(): PeopleDao

    abstract fun moviesDao(): MoviesDao

    abstract fun tvShowsDao(): TvShowsDao
}