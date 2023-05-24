package com.bosseurs.medcare.ui.screens.main

data class HomeUiState(
    val isUserConnected: Boolean = false,
    val username: String = "",
    val patientID : String =""
) {
}
