package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.PickerScreen
import com.bosseurs.medcare.ui.shared.PickerStyle
import com.bosseurs.medcare.ui.shared.SelectHeightScreen
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor

@Composable
fun obsiteHeight(
    navController: NavController,
){
    var targetHeight by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SelectHeightScreen(targetHeight)

        //Spacer(modifier = Modifier.height(68.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Image(modifier = Modifier
                .width(200.dp)
                .fillMaxHeight(0.94f) ,
                painter = painterResource(id = R.drawable.human_height_obseti),
                contentDescription ="this is a" )
            Spacer(modifier = Modifier.width(30.dp))
            PickerScreen(pickerStyle = PickerStyle()) { height ->
                targetHeight = height
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Bottom) {
            CustomButtonObesite(
                textId = R.string.retourner_label, onClick = {}, color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)

            CustomButtonObesite(textId = R.string.CONTINUE, onClick = {}, color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)
        }

    }
}
