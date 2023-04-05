package com.bosseurs.medcare.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomTextField
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel : LoginViewModel = viewModel()
){
    val loginUiState by loginViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0XFF090F47)
                    )
                }
            }
        }
    ) {
            Column(modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
                ,Arrangement.spacedBy(15.dp),
        ) {
                    Text(
                        text= stringResource(R.string.login_welcome),
                        style = MaterialTheme.typography.h2,
                    )
                CustomTextField(
                    labelText = R.string.username,
                    leadingIconId = R.drawable.person_icon ,
                    iconDescription ="Person Icon" ,
                    keyboardType = KeyboardType.Text,
                    trailingIconId = null
                )
                CustomTextField(
                    labelText = R.string.password,
                    leadingIconId = R.drawable.password_icon ,
                    iconDescription = "Password Icon" ,
                    keyboardType = KeyboardType.Password ,
                    trailingIconId = null
                )
//                    OutlinedTextField(value = loginViewModel.userGuess, onValueChange = {loginViewModel.updateUserGuess(it)} , label = {}, modifier = Modifier.fillMaxWidth())
//                    OutlinedTextField(value = loginViewModel.passwordGuess, onValueChange = {loginViewModel.updatePasswordGuess(it)} , label = {}, modifier = Modifier.fillMaxWidth())
                    CustomButton(textId = R.string.connexion_btn,
                        onClick = {
                                  navController.navigate(Screen.HomeScreen.route)
                        },
                        color = BlueColor,
                        textColor = TextForBlueButtonColor,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                        Text(
                            text = stringResource(id = R.string.sign_up_txt),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                }

            }
        }

//@Preview(showBackground = true)
//@Composable
//fun Launch() {
//    MedCareTheme {
//        LoginScreen()
//    }
//}
