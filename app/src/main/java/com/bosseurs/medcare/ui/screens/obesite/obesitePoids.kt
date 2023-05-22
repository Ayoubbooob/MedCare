package com.bosseurs.medcare.ui.screens.obesite

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.VerticalNumberPicker
import com.bosseurs.medcare.ui.shared.HorizontalNumberPicker
import com.bosseurs.medcare.ui.shared.PickerButton
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen


@Composable
fun NumberPicker(context:Context  ,
                 navController: NavController ,
                 obesiteModel : obesiteModel = viewModel()
) {

        var number = remember { mutableStateOf(20) }
        val max=remember { mutableStateOf(400) }
        val min=remember { mutableStateOf(5) }
        Box(modifier = Modifier.fillMaxSize()
        ) {
            //var obesiteModel : obesiteModel = viewModel()
            Text(
                text = "selectionner votre poids :",
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .align(Alignment.TopCenter))
            Column(

                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                content = {
                    Text(text = "${obesiteModel.uiState.value}")
                    Image(painter = painterResource(id = R.drawable.weight_mesure), contentDescription ="this is image contente" )
                    HorizontalNumberPicker(
                        min = 10,
                        max = 100,
                        default = 50,
                        onValueChange = { value ->
                            obesiteModel.updatePoids(poids = value)
                            Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                    Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Bottom) {
                        CustomButtonObesite(
                            textId = R.string.retourner_label, onClick = {
                                navController.popBackStack()
                            },
                            color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)

                        CustomButtonObesite(textId = R.string.CONTINUE, onClick = {
                            navController.navigate(Screen.obesiteResult.route)
                        }, color = BlueColor, textColor = TextForBlueButtonColor ,
                            CustomWidth = 176  , CustomHeight = 50)
                    }

                },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally,
            )


        }

fun onValueChange(value: Int,context:Context,) {
    Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
}

}
