@file:OptIn(ExperimentalFoundationApi::class)

package com.bosseurs.medcare.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.httpRequest.Patient
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.MedCareTheme
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen
import com.google.gson.Gson


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    isUserConnected: Boolean = false,
    username: String = "",
    homeViewModel: HomeViewModel = viewModel(),
    patientID : String = ""
) {
    homeViewModel.updateHomeDetails(isUserConnected, username,patientID)
    val homeUiState by homeViewModel.uiState.collectAsState()
    val context = LocalContext.current
    Scaffold(
        topBar = {Header(
            isUserConnected = homeUiState.isUserConnected,
            username=homeUiState.username + homeUiState.patientID
        )},
        bottomBar = { FooterBarInstance(navController, homeUiState)}
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = stringResource(R.string.cat_principale),
                style = Typography1.h2,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(10.dp)
            )
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    MyCard(
                        title = stringResource(R.string.info_obesite_panel),
                        backImage = painterResource(id = R.drawable.fat),
                        onClick = {
                            val homeUiStateJson = Gson().toJson(homeUiState)
                            navController.navigate(Screen.MenuInfoScreen.passArgs(homeUiStateJson))
                        },
                        patientID = homeUiState.patientID // Pass the patientID value
                    )
                }
                item {
                    MyCard(
                        title = stringResource(R.string.hopital_ibn_sina_panel),
                        backImage = painterResource(id = R.drawable.cat1),
                        onClick = {
//                            Toast
//                                .makeText(context, "cette route n'est pas encore disponible", Toast.LENGTH_SHORT)
//                                .show()

                            navController.navigate(Screen.MenuInfoHospitalScreen.route)


                        },
                        patientID = homeUiState.patientID // Pass the patientID value
                    )
                }
                item {
                    MyCard(
                        title = stringResource(R.string.calcul_imc_panel),
                        backImage = painterResource(id = R.drawable.balance),
                        onClick = {
                            navController.navigate(Screen.obesiteGenre.route)
                        },
                        patientID = homeUiState.patientID // Pass the patientID value
                    )
                }
                item {
                    MyCard(
                        title = stringResource(R.string.rendez_vous_panel),
                        backImage = painterResource(id = R.drawable.appointment),
                        onClick = {
                            if(homeUiState.isUserConnected){
//                                navController.navigate(Screen.AppointmentScreen.route)
                                navController.navigate(Screen.AppointmentScreen.passArgs(true,patientID))
                            } else {
                                navController.navigate(Screen.LoginScreen.route)
                            }
                        },
                        patientID = homeUiState.patientID // Pass the patientID value
                    )
                }
            }
        }
    }
}


@Composable
fun Header(
    isUserConnected: Boolean,
    username: String,
    modifier: Modifier = Modifier){
    val profilPhoto :Painter = if(isUserConnected) painterResource(R.drawable.profil_image)
    else painterResource(R.drawable.profil)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            //.padding(bottom = 30.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10))
                .background(BlueColor)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = profilPhoto,
                    contentDescription = "profil_image",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                )
                Icon(
                    Icons.Outlined.Notifications,
                    tint = Color.White,
                    contentDescription = "icon"
                )
            }
            Column() {
                Text(
                    //modifier = modifier.align(Alignment.),
                    text = stringResource(R.string.greeting_homescreen) + " " + username,
                    color = Color.White,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = stringResource(R.string.welcome_homescreen),
                    color = Color.White,
                )
            }
        }
    }
}

@Composable
fun MyCard(modifier: Modifier = Modifier,
           title: String = "",
           backImage: Painter = painterResource(R.drawable.card_img1),
           onClick: () -> Unit = {},
           patientID: String = "" // Add the patientID parameter
) {
    Card(
        backgroundColor = MaterialTheme.colors.onSurface, //Ayoub a ajoute cette ligne
        elevation = 10.dp,
        shape = RoundedCornerShape(18.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(horizontal = 14.dp, vertical = 6.dp)

            .clickable(
                enabled = true,
                onClickLabel = "Clickable image",
                onClick = onClick
            ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = backImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(0.6f)
            )
            Text(text = title,
                style = Typography1.h3,
                textAlign = TextAlign.Center
            )
        }

    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    MedCareTheme() {
//        HomeScreen(
//            navController = rememberNavController(),
//            patient = it.arguments?.getSerializable("patient") as? Patient
//        )
//    }
//}