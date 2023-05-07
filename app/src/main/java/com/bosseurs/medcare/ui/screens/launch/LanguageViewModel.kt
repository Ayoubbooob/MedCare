package com.bosseurs.medcare.ui.screens.launch

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.*

class LanguageViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LanguageUiState())
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    fun updateLocale(locale: Locale){
        _uiState.update { currentState ->
            currentState.copy(
                locale = locale
            )
        }
    }
}