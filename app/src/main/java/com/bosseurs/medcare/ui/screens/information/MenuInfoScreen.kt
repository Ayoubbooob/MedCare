package com.bosseurs.medcare.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.Typography1


@Composable
fun MenuInfoScreen(navController: NavController = rememberNavController(),
                   modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {Header()},
        bottomBar = { FooterBarInstance()}
    ) {
        Column() {
            Text(
                text = stringResource(R.string.info_gererales),
                style = Typography1.h2,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(10.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    MyCard(
                        backImage = painterResource(id = R.drawable.card_img2)
                    )
                }
                item {
                    MyCard(
                        backImage = painterResource(id = R.drawable.card_img2)
                    )
                }
            }
        }
    }
}