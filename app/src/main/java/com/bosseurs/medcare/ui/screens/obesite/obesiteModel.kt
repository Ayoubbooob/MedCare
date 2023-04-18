package com.bosseurs.medcare.ui.screens.obesite

import androidx.lifecycle.ViewModel
import com.bosseurs.medcare.ui.screens.main.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class obesiteModel : ViewModel() {
    private val _uiState = MutableStateFlow(obesiteState())
    val uiState: StateFlow<obesiteState> = _uiState.asStateFlow()

    fun updateTaille(taille: Float) {
        _uiState.update { currentState ->
            currentState.copy(
                taille = taille
            )
        }
    }
    fun updateGenre(genre: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                genre = genre
            )
        }
    }
    fun updatePoids(poids: Float) {
        _uiState.update { currentState ->
            currentState.copy(
                poids = poids
            )
        }
    }
}