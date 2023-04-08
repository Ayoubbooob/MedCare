package com.bosseurs.medcare.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bosseurs.medcare.ui.screens.description.DescriptionUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(DescriptionUiState())
    val uiState: StateFlow<DescriptionUiState> = _uiState.asStateFlow()
    var userGuess by mutableStateOf("")
        private set
    var passwordGuess by mutableStateOf("")
        private set
    fun updateUserGuess(guessedUser: String){
        userGuess = guessedUser
    }
    fun updatePasswordGuess(guessedPass : String){
        passwordGuess = guessedPass
    }


}