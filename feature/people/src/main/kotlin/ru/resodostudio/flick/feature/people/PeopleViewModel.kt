package ru.resodostudio.flick.feature.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.resodostudio.core.data.repository.PeopleRepository
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    peopleRepository: PeopleRepository,
) : ViewModel() {

    val peopleState = peopleRepository.getPeople().cachedIn(viewModelScope)
}