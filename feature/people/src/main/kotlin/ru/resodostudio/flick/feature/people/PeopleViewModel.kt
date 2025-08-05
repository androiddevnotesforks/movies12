package ru.resodostudio.flick.feature.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.resodostudio.core.data.repository.PeopleRepository
import ru.resodostudio.flick.core.model.Person
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    peopleRepository: PeopleRepository,
) : ViewModel() {

    val peopleState: Flow<PagingData<Person>> = peopleRepository.getPeople()
        .cachedIn(viewModelScope)
}