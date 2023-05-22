package com.bosseurs.medcare.ui.screens.hospital

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.screens.information.INFO_OBESITE
import com.bosseurs.medcare.ui.screens.information.MDDocument
import com.bosseurs.medcare.ui.screens.information.YoutubeScreen
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.Typography1
import org.commonmark.node.Document
import org.commonmark.parser.Parser

@Composable
fun HospitalInfoScreen(
    modifier : Modifier = Modifier,
    navController: NavController = rememberNavController()
){
    Scaffold(
        topBar = { CustomTopAppBar(
            title = stringResource(R.string.renseignements_hopital_menu),
            onClick = { navController.popBackStack() },
        ) },
        bottomBar = { FooterBarInstance(navController) }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = stringResource(R.string.renseignements_hopital_menu),
                style = Typography1.h1,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp)
            )

            //YoutubeScreen(videoId = videoUri)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp),
            ) {
                item {
                    Image(
                        painter = painterResource(R.drawable.ibnsina_services),
                        contentDescription = "ibn sina services",
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text("Le Centre hospitalier universitaire Ibn Sina (appelé CHU Ibn Sina / CHUIS ) est le plus grand centre hospitalier universitaire du Maroc.\n" +
                            "\n" +
                            "Il est situé dans la capitale Rabat.\n" +
                            "\n" +
                            "Le CHU Ibn Sina est placé sous la tutelle du Ministère de la Santé")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HospitalInfoScreenPreview() {
    HospitalInfoScreen()
}