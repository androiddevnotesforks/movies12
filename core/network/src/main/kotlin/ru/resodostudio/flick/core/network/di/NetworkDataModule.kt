package ru.resodostudio.flick.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.resodostudio.flick.core.network.FlickNetworkDataSource
import ru.resodostudio.flick.core.network.ktor.KtorFlickNetwork

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkDataModule {

    @Binds
    internal abstract fun bindsFlickNetworkDataSource(
        impl: KtorFlickNetwork,
    ): FlickNetworkDataSource
}