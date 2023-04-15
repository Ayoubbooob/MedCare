package com.bosseurs.medcare.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun updateHomeDetails(isUserConnected: Boolean, username: String){
        _uiState.update { currentState ->
            currentState.copy(
                isUserConnected = isUserConnected,
                username = username
            )
        }
    }
}