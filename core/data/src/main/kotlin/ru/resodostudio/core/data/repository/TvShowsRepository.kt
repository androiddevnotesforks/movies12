package ru.resodostudio.core.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.model.TvShow

interface TvShowsRepository {

    fun getTvShows(): Flow<PagingData<TvShow>>
}