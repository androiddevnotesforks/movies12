package ru.resodostudio.flick.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.flick.core.database.model.MovieEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    fun getMovieEntities(): PagingSource<Int, MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovieEntity(id: Int): Flow<MovieEntity>

    @Upsert
    suspend fun upsertMovies(movies: List<MovieEntity>)
}