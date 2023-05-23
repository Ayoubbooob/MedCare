package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButtonObesite
import com.bosseurs.medcare.ui.shared.shadow
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun ObesiteResult(
    navController: NavController,
    obesiteModel : obesiteModel = viewModel()
    //modifier : Modifier
    //navController: NavController = rememberNavController()
){

    Scaffold(
        //backgroundColor = MaterialTheme.colors.onBackground ,
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0XFF090F47)
                    )
                }
            }
        },

        floatingActionButton = {
            Row(modifier = Modifier.padding(20.dp) ,  verticalAlignment = Alignment.Bottom) {
                CustomButtonObesite(
                    textId = R.string.valider_imc, onClick = {
                        navController.popBackStack(route = Screen.HomeScreen.route, inclusive = false)
                    },
                    color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)
            }
        } ,

    ) {
        //var obesiteModel : obesiteModel = viewModel()
        val obesiteUIState by obesiteModel.uiState.collectAsState()
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize(fraction = 0.8f)
                        .shadow(
                            color = MaterialTheme.colors.onSecondary,
                            offsetX = 0.dp,
                            offsetY = 22.dp,
                            blurRadius = 14.dp,
                        )
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Blue)
                ) {
                    //val result = obesiteUIState.taille*obesiteUIState.taille
                    Column() {
                        Text(text = "Votre resultat est ${obesiteUIState.poids /(obesiteUIState.taille.toFloat()*obesiteUIState.taille.toFloat())}" , color = Color.White , fontSize = 20.sp)

                    }

                }
            }

        }

    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ObesiteResultScreenPreview() {
    //ObesiteResult()
}