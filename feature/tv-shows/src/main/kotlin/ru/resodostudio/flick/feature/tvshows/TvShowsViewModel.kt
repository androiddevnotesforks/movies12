package ru.resodostudio.flick.feature.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.core.data.repository.TvShowsRepository
import ru.resodostudio.flick.core.model.TvShow
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    tvShowsRepository: TvShowsRepository,
) : ViewModel() {

    val tvShowsState: Flow<PagingData<TvShow>> = tvShowsRepository.getTvShows()
        .cachedIn(viewModelScope)
}