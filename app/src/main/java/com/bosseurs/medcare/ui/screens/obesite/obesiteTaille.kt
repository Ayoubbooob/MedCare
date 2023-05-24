package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.PickerScreen
import com.bosseurs.medcare.ui.shared.PickerStyle
import com.bosseurs.medcare.ui.shared.SelectHeightScreen
import com.bosseurs.medcare.ui.theme.AppBarTextStyle
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun obsiteHeight(
    navController: NavController,
    obesiteModel : obesiteModel ,
    isUserConnected: Boolean = false,
    patientID: String = ""
){
    val TailleUIState by obesiteModel.uiState.collectAsState()
    obesiteModel.updateObesiteDetails(isUserConnected,patientID)
    var targetHeight by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Row() {
                        Column(modifier = Modifier.padding(6.dp)) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color(0XFF090F47)
                            )
                        }
                        val context = LocalContext.current
                        Column() {
                            Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
                                .padding(6.dp)) {
                                Column() {
                                    Text(text = stringResource(R.string.genre_select_message), style = AppBarTextStyle)
                                }
                                Spacer(modifier = Modifier.padding(6.dp))
                                Column() {
                                    Text(text = stringResource(R.string.gennre_taille_bold), style = AppBarTextStyle)
//                                Text(text = patientID, style = AppBarTextStyle)
                                }

                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
            Row(horizontalArrangement = Arrangement.Center , modifier = Modifier.padding(10.dp)) {
                CustomButtonObesite(
                    textId = R.string.continue_label, onClick = {
                        obesiteModel.updateTaille(taille = targetHeight.toFloat()/100.toFloat())
                        navController.navigate(Screen.obesitePoid.passArgs(true,patientID))
                    },
                    color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 70)
            }

        }
    ) {
        SelectHeightScreen(targetHeight)

        //Spacer(modifier = Modifier.height(68.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            //val context = LocalContext.current
            Image(modifier = Modifier
                .width(200.dp)
                .fillMaxHeight(0.6f)
                .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.human_height_obseti),
                contentDescription ="this is a" )
            Spacer(modifier = Modifier.width(30.dp))
            PickerScreen(pickerStyle = PickerStyle()) { height ->
                targetHeight = height
            }
        }

    }
    }


