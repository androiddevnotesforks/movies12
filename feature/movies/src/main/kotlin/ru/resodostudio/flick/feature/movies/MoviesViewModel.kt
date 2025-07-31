package ru.resodostudio.flick.feature.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import ru.resodostudio.core.data.repository.MoviesRepository
import ru.resodostudio.flick.core.model.data.Movie
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    //moviesRepository: MoviesRepository
) : ViewModel() {

    val moviesUiState: StateFlow<MoviesUiState> = flowOf(MoviesUiState.Loading)
        .onStart { emit(MoviesUiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MoviesUiState.Loading,
        )
}

sealed interface MoviesUiState {

    data object Loading : MoviesUiState

    data class Success(
        val movies: List<Movie>
    ) : MoviesUiState

    data class Error(
        val errorMessage: String
    ) : MoviesUiState
}