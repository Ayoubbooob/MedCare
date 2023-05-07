package com.bosseurs.medcare.ui.screens.hospital

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.screens.main.Header
import com.bosseurs.medcare.ui.screens.main.HomeUiState
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun MenuInfoHospitalScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    homeUiState: HomeUiState = HomeUiState()
) {

    Scaffold(
        topBar = { Header(
            isUserConnected = homeUiState.isUserConnected,
            username= homeUiState.username
        ) },
        bottomBar = { FooterBarInstance(navController, homeUiState) }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = stringResource(R.string.info_ibn_sina_menu_title),
                style = Typography1.h2,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(10.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
            ) {
                item(){
                    MyCard(
                        title= stringResource(R.string.renseignements_hopital_menu),
                        onClick = {
                            navController.navigate(Screen.HospitalInfoScreen.route)
                        }
                    )
                }
                item(){
                    MyCard(
                        title= stringResource(R.string.service_bariatique_menu),
                        onClick = {
                            navController.navigate(Screen.BariaticServiceScreen.route)
                        }
                    )
                }
                item(){
                    MyCard(
                        title= stringResource(R.string.procedure_medicales_menu),
                        onClick = {
                                navController.navigate(Screen.ProceduresScreen.route)
                        }
                    )
                }

            }
        }
    }
}

@Composable
fun MyCard(modifier: Modifier = Modifier,
           title: String = "",
           backImage: Painter = painterResource(R.drawable.cat1),
           onClick: () -> Unit = {}
) {
    Card(
        backgroundColor = MaterialTheme.colors.onSurface, //Ayoub a ajoute cette ligne
        elevation = 10.dp,
        shape = RoundedCornerShape(18.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 14.dp, vertical = 6.dp)
            .clickable(
                enabled = true,
                onClickLabel = "Clickable image",
                onClick = onClick
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = backImage,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.15f)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))

            Text(text = title,
                style = Typography1.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuInfoHospitalScreenPreview() {
    MenuInfoHospitalScreen()
}