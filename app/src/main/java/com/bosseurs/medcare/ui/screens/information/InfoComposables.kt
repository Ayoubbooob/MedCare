package com.bosseurs.medcare.ui.screens.information

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.theme.Typography1
import org.commonmark.node.Document
import org.commonmark.parser.Parser

@Composable
fun InfoContent(
    INFO_CONTENT : String,
    videoUri: String,
    title: String,
    modifier : Modifier = Modifier
){
    Scaffold(
        topBar = { Header() },
        bottomBar = { FooterBarInstance() }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = title,
                style = Typography1.h1,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp)
            )
            /*VideoView(videoUri =
                "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
            )*/
            YoutubeScreen(videoId = videoUri)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
            ) {
                item {
                    val parser = Parser.builder().build()
                    val root = parser.parse(INFO_CONTENT) as Document
                    Column(modifier=Modifier.padding(horizontal = 10.dp)) {
                        MDDocument(root)
                    }
                }
            }
        }
    }
}

@Composable
fun Header(){
    TopAppBar(
        backgroundColor = Color.White,
        modifier = Modifier.wrapContentWidth(align = Alignment.Start))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0XFF090F47)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Back",
                    tint = Color(0XFF090F47)
                )
            }
        }
    }
}

