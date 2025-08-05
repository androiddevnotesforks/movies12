package ru.resodostudio.flick.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.database.model.TvShowEntity

@Dao
interface TvShowsDao {

    @Query("SELECT * FROM tv_shows ORDER BY popularity DESC")
    fun getTvShowEntities(): PagingSource<Int, TvShowEntity>

    @Query("SELECT * FROM tv_shows WHERE id = :id")
    fun getTvShowEntity(id: Int): Flow<TvShowEntity>

    @Upsert
    suspend fun upsertTvShows(tvShow: List<TvShowEntity>)
}