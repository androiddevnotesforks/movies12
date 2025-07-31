package ru.resodostudio.flick.feature.movie

import androidx.lifecycle.SavedStateHandle
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
import ru.resodostudio.flick.core.model.data.MovieExtended
import ru.resodostudio.flick.feature.movie.navigation.MovieArgs
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val movieArgs: MovieArgs = MovieArgs(savedStateHandle)

    private val movieId = movieArgs.movieId

    val movieUiState: StateFlow<MovieUiState> = flowOf(MovieUiState.Loading)
        .onStart { emit(MovieUiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MovieUiState.Loading,
        )
}

sealed interface MovieUiState {

    data object Loading : MovieUiState

    data class Success(
        val data: MovieExtended
    ) : MovieUiState

    data class Error(
        val errorMessage: String
    ) : MovieUiState
}