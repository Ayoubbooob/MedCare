package com.bosseurs.medcare.ui.screens.description

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.utils.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DescriptionViewModel : ViewModel(){
    private var index = 0
    private val _uiState = MutableStateFlow(DescriptionUiState())
    val uiState: StateFlow<DescriptionUiState> = _uiState.asStateFlow()

    fun updateDetailsInterface(navController: NavController){
        index++
        when(index){
            1 -> _uiState.update { currentState ->
                currentState.copy(bigText = R.string.title_description_imc,
                descriptionText = R.string.description_imc,
                image = R.drawable.int4,

                )

            }
            2 -> _uiState.update { currentState ->
                currentState.copy(bigText = R.string.title_description_medecin,
                    descriptionText = R.string.description_medecin,
                    image = R.drawable.int5)
            }
            3 -> moveToAuthScreen(navController)


        }
    }

    private fun  moveToAuthScreen(navController: NavController){
        navController.navigate(Screen.AuthScreen.route)
    }


}