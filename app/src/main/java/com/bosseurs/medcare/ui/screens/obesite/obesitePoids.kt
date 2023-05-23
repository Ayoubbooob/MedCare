package com.bosseurs.medcare.ui.screens.obesite

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.HorizontalNumberPicker
import com.bosseurs.medcare.ui.theme.AppBarTextStyle
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen


@Composable
fun NumberPicker(context:Context  ,
                 navController: NavController ,
                 obesiteModel : obesiteModel
) {

        var number = remember { mutableStateOf(20) }
        val max=remember { mutableStateOf(400) }
        val min=remember { mutableStateOf(5) }
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
                                        Text(text = "selectionner votre poids(kg)", style = AppBarTextStyle)
                                    }

                                }
                            }
                        }
                    }
                }
            },

        ) {

            Box(modifier = Modifier.fillMaxSize()
            ) {
                //var obesiteModel : obesiteModel = viewModel()
                Column(

                    Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    content = {
                        Image(painter = painterResource(id = R.drawable.weight_mesure), contentDescription ="this is image contente" )
                        Spacer(modifier = Modifier.padding(12.dp))
                        HorizontalNumberPicker(
                            min = 10,
                            max = 100,
                            default = 50,
                            onValueChange = { value ->
                                obesiteModel.updatePoids(poids = value)
                                Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
                            }
                        )
                        Row(horizontalArrangement = Arrangement.Center , modifier = Modifier.padding(13.dp)) {

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

        }

fun onValueChange(value: Int,context:Context,) {
    Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
}

}
