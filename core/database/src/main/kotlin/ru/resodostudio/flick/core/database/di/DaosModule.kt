package ru.resodostudio.flick.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.flick.core.database.FlickDatabase
import ru.resodostudio.flick.core.database.dao.PeopleDao
import ru.resodostudio.flick.core.database.dao.RemoteKeysDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {

    @Provides
    fun providesRemoteKeysDao(
        database: FlickDatabase,
    ): RemoteKeysDao = database.remoteKeysDao()

    @Provides
    fun providesPeopleDao(
        database: FlickDatabase,
    ): PeopleDao = database.peopleDao()
}