package ru.resodostudio.flick.feature.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.resodostudio.core.data.repository.AuthenticationRepository
import ru.resodostudio.core.data.repository.UserDataRepository
import ru.resodostudio.flick.core.common.util.Constants.REQUEST_TOKEN
import ru.resodostudio.flick.feature.profile.navigation.ProfileRoute
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val authenticationRepository: AuthenticationRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val profileDestination: ProfileRoute = savedStateHandle.toRoute()
    private val requestTokenState = savedStateHandle.getStateFlow(
        key = REQUEST_TOKEN,
        initialValue = profileDestination.requestToken,
    )

    val profileUiState = combine(
        userDataRepository.userData,
        requestTokenState,
    ) { userData, requestToken ->
        ProfileUiState.Success(
            isLoggedIn = userData.sessionId.isNotEmpty(),
            requestToken = userData.requestToken,
            requestTokenFromArgs = requestToken ?: "",
        )
    }
        .catch { ProfileUiState.Error }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ProfileUiState.Loading,
        )

    fun getRequestToken() {
        viewModelScope.launch {
            authenticationRepository.getRequestToken()
        }
    }

    fun clearRequestToken() {
        viewModelScope.launch {
            userDataRepository.updateRequestToken("")
        }
    }

    fun createSession(requestToken: String) {
        viewModelScope.launch {
            authenticationRepository.createSession(requestToken)
        }
    }

    fun deleteSession() {
        viewModelScope.launch {
            authenticationRepository.deleteSession()
        }
    }
}

sealed interface ProfileUiState {

    object Loading : ProfileUiState

    data class Success(
        val isLoggedIn: Boolean,
        val requestToken: String,
        val requestTokenFromArgs: String,
    ) : ProfileUiState

    object Error : ProfileUiState
}