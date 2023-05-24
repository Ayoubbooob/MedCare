package com.bosseurs.medcare.ui.screens.appointment

import androidx.lifecycle.ViewModel
import com.bosseurs.medcare.ui.screens.main.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class AppointmentViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppointmentUiState())
    val uiState: StateFlow<AppointmentUiState> = _uiState.asStateFlow()

    fun updateAppointmentDetails(isUserConnected: Boolean,patientID : String){
        _uiState.update { currentState ->
            currentState.copy(
                isUserConnected = isUserConnected,
                patientID =patientID
            )
        }
    }
}