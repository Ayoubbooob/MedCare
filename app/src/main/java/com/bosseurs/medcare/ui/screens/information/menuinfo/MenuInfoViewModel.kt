package com.bosseurs.medcare.ui.screens.information.menuinfo

import androidx.lifecycle.ViewModel
import com.bosseurs.medcare.ui.screens.information.INFO_DIABETE
import com.bosseurs.medcare.ui.screens.information.INFO_OBESITE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MenuInfoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MenuInfoUiState())
    val uiState: StateFlow<MenuInfoUiState> = _uiState.asStateFlow()

    fun loadInfoDetails(){
        /*Ici on doit faire appel à l'api du backend pour charger les informations*/

        //Ca c'est juste pour example
        val info1 = InfoDetail(
            title = "C'est quoi l'obésité?",
            videoUri = "vzQxzcBV8FM",
            infoContentMarkdown = INFO_OBESITE
        )
        val info2 = InfoDetail(
            title = "C'est quoi le diabète?",
            videoUri = "GUxg-MsE-y0",
            infoContentMarkdown = INFO_DIABETE
        )

        _uiState.update { currentState ->
            currentState.copy(info_details = listOf(info1, info2))
        }
    }
}