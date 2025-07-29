package ru.resodostudio.flick.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.flick.core.database.FlickDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesFlickDatabase(
        @ApplicationContext context: Context,
    ): FlickDatabase = Room.databaseBuilder(
        context,
        FlickDatabase::class.java,
        "flick-database",
    ).build()
}