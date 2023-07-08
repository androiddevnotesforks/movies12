package ru.resodostudios.movies.feature.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.resodostudios.movies.feature.favorites.domain.model.FavoriteMovie
import ru.resodostudios.movies.feature.favorites.domain.repository.FavoritesRepository
import ru.resodostudios.movies.feature.favorites.domain.util.MovieEvent
import ru.resodostudios.movies.feature.movie.data.model.Movie
import ru.resodostudios.movies.feature.movie.domain.use_case.GetMovieUseCase
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: GetMovieUseCase,
    private val repository: FavoritesRepository
) : ViewModel() {

    private val _movie = MutableStateFlow(Movie())
    private val _isLoading = MutableStateFlow(true)
    private val _isError = MutableStateFlow(false)

    val movie = _movie.asStateFlow()
    val isLoading = _isLoading.asStateFlow()
    val isError = _isError.asStateFlow()

    fun getMovie(id: Int) {
        viewModelScope.launch {
            movieUseCase.invoke(id).let {
                if (it.isSuccessful) {
                    _movie.value = it.body()!!
                    _isLoading.value = false
                    _isError.value = false
                } else {
                    _isLoading.value = false
                    _isError.value = true
                }
            }
        }
    }

    fun onEvent(event: MovieEvent) {
        when (event) {
            is MovieEvent.AddMovie -> {
                val eventMovie = event.movie
                val favoriteMovie = FavoriteMovie(
                    id = eventMovie.id,
                    image = eventMovie.image?.original,
                    rating = eventMovie.rating?.average,
                    name = eventMovie.name
                )

                viewModelScope.launch {
                    repository.upsertMovie(favoriteMovie)
                }
            }

            is MovieEvent.DeleteMovie -> {
                viewModelScope.launch {
                    repository.deleteMovie(event.movie)
                }
            }
        }
    }
}