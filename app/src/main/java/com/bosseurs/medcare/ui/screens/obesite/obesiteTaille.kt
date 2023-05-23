package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun obsiteHeight(
    navController: NavController,
    obesiteModel : obesiteModel
){
    //var obesiteModel : obesiteModel = viewModel()
    var targetHeight by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)) {
                    Column() {
                        Text(text = stringResource(R.string.genre_select_message), style = Typography1.subtitle1)
                    }
                    Spacer(modifier = Modifier.padding(6.dp))
                    Column() {
                        Text(text = stringResource(R.string.gennre_taille_bold), style = Typography1.h1)
                    }

                }
            }
        }  ,
        bottomBar = {
            Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Bottom) {
                CustomButtonObesite(
                    textId = R.string.retourner_label, onClick = {
                        //Text(text = "Votre resultat est ${targetHeight}" , color = Color.Blue , fontSize = 20.sp)
                        obesiteModel.updateTaille(taille = targetHeight.toFloat()/100.toFloat())
                        navController.popBackStack()
                    },
                    color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)

                CustomButtonObesite(textId = R.string.CONTINUE, onClick = {
                    obesiteModel.updateTaille(taille = targetHeight.toFloat()/100)
                    navController.navigate(Screen.obesitePoid.route)
                }, color = BlueColor, textColor = TextForBlueButtonColor ,
                    CustomWidth = 176  , CustomHeight = 50)
            }
        }
    ) {
        SelectHeightScreen(targetHeight)

        //Spacer(modifier = Modifier.height(68.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            //val context = LocalContext.current
            Image(modifier = Modifier
                .width(200.dp)
                .fillMaxHeight(0.8f)
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


