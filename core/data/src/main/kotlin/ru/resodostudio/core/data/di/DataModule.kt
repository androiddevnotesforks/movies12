package ru.resodostudio.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.core.data.repository.AuthenticationRepository
import ru.resodostudio.core.data.repository.AuthenticationRepositoryImpl
import ru.resodostudio.core.data.repository.MoviesRepository
import ru.resodostudio.core.data.repository.MoviesRepositoryImpl
import ru.resodostudio.core.data.repository.PeopleRepository
import ru.resodostudio.core.data.repository.PeopleRepositoryImpl
import ru.resodostudio.core.data.repository.TvShowsRepository
import ru.resodostudio.core.data.repository.TvShowsRepositoryImpl
import ru.resodostudio.core.data.repository.UserDataRepository
import ru.resodostudio.core.data.repository.UserDataRepositoryImpl
import ru.resodostudio.core.data.util.ConnectivityManagerNetworkMonitor
import ru.resodostudio.core.data.util.NetworkMonitor

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    internal abstract fun bindsMoviesRepository(
        impl: MoviesRepositoryImpl,
    ): MoviesRepository

    @Binds
    internal abstract fun bindsTvShowsRepository(
        impl: TvShowsRepositoryImpl,
    ): TvShowsRepository

    @Binds
    internal abstract fun bindsPeopleRepository(
        impl: PeopleRepositoryImpl,
    ): PeopleRepository

    @Binds
    internal abstract fun bindsUserDataRepository(
        impl: UserDataRepositoryImpl,
    ): UserDataRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(
        impl: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun bindsAuthenticationRepository(
        impl: AuthenticationRepositoryImpl,
    ): AuthenticationRepository
}