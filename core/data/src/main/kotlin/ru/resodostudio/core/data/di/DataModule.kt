package ru.resodostudio.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.core.data.repository.MoviesRepository
import ru.resodostudio.core.data.repository.MoviesRepositoryImpl
import ru.resodostudio.core.data.repository.PeopleRepository
import ru.resodostudio.core.data.repository.PeopleRepositoryImpl
import ru.resodostudio.core.data.repository.UserDataRepository
import ru.resodostudio.core.data.repository.offline.OfflineUserDataRepository
import ru.resodostudio.core.data.util.ConnectivityManagerNetworkMonitor
import ru.resodostudio.core.data.util.NetworkMonitor

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    internal abstract fun bindsMoviesRepository(
        moviesRepository: MoviesRepositoryImpl,
    ) : MoviesRepository

    @Binds
    internal abstract fun bindsPeopleRepository(
        peopleRepository: PeopleRepositoryImpl,
    ): PeopleRepository

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepositoryImpl: OfflineUserDataRepository
    ): UserDataRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}