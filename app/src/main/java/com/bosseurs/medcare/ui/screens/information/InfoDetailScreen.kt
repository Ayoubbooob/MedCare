package com.bosseurs.medcare.ui.screens.information

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.screens.main.HomeUiState
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.Typography1
import org.commonmark.node.Document
import org.commonmark.parser.Parser

@Composable
fun InfoDetailScreen(
    videoUri: String = "vzQxzcBV8FM",
    title: String = stringResource(id = R.string.titre_info_obesite),
    infoContentMarkdown : String = INFO_OBESITE,
    modifier : Modifier = Modifier,
    navController: NavController = rememberNavController() ,
    homeUIState : HomeUiState = HomeUiState()
){
    Scaffold(
        topBar = { CustomTopAppBar(
            title = title,
            onClick = { navController.popBackStack() },
        ) },
        bottomBar = { FooterBarInstance(navController , homeUIState) }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = title,
                style = Typography1.h1,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp)
            )
            /* //pour une video qui n'est pas sur youtube
            VideoView(videoUri =
                "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
            )*/
            //video sur youtube
            YoutubeScreen(videoId = videoUri)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
            ) {
                item {
                    val parser = Parser.builder().build()
                    val root = parser.parse(infoContentMarkdown) as Document
                    Column(modifier= Modifier.padding(horizontal = 10.dp)) {
                        MDDocument(root)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InfoDetailScreenPreview() {
    InfoDetailScreen()
}