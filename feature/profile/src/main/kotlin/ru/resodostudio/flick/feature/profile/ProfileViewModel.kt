package ru.resodostudio.flick.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.resodostudio.core.data.repository.UserDataRepository
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    userDataRepository: UserDataRepository,
) : ViewModel() {

    val profileUiState = userDataRepository.userData
        .map { userData ->
            ProfileUiState.Success(
                isLoggedIn = userData.sessionId.isNotEmpty(),
            )
        }
        .catch { ProfileUiState.Error }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ProfileUiState.Loading,
        )
}

sealed interface ProfileUiState {

    object Loading : ProfileUiState

    data class Success(
        val isLoggedIn: Boolean,
    ) : ProfileUiState

    object Error : ProfileUiState
}