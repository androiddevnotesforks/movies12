package ru.resodostudio.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.core.data.repository.PeopleRepository
import ru.resodostudio.core.data.repository.PeopleRepositoryImpl
import ru.resodostudio.core.data.repository.UserDataRepository
import ru.resodostudio.core.data.repository.offline.OfflineUserDataRepository
import ru.resodostudio.core.data.util.ConnectivityManagerNetworkMonitor
import ru.resodostudio.core.data.util.NetworkMonitor
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import ru.resodostudio.flick.core.network.ktor.KtorFlickNetwork

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    internal abstract fun bindPeopleRepository(
        peopleRepository: PeopleRepositoryImpl,
    ): PeopleRepository

    @Binds
    internal abstract fun bindUserDataRepository(
        userDataRepositoryImpl: OfflineUserDataRepository
    ): UserDataRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun bindKtor(
        ktor: KtorFlickNetwork,
    ): FlickNetworkDataSource
}