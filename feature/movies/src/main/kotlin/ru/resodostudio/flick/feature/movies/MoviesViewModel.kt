package ru.resodostudio.flick.feature.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.core.data.repository.MoviesRepository
import ru.resodostudio.flick.core.model.data.Movie
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    moviesRepository: MoviesRepository,
) : ViewModel() {

    val moviesState: Flow<PagingData<Movie>> = moviesRepository.getMovies()
        .cachedIn(viewModelScope)
}