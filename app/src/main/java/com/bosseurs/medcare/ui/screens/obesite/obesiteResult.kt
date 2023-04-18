package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.ImageContainer
import com.bosseurs.medcare.ui.shared.ImageShadowContainer
import com.bosseurs.medcare.ui.shared.shadow
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.ImageModel

@Composable
fun ObesiteResult(
    //navController: NavController,
    //modifier : Modifier
    //navController: NavController = rememberNavController()
){

    Scaffold(
        //backgroundColor = MaterialTheme.colors.onBackground ,
        topBar = {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.wrapContentWidth(align = Alignment.Start))
            {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0XFF090F47)
                    )
                }
            }
        },
        bottomBar = {
            //FooterBarInstance()
        }
    ) {
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
            //.fillMaxSize()
            .padding(6.dp)) {
            Column() {
                Text(text = stringResource(R.string.genre_select_message), style = Typography1.subtitle1)
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Column() {
                Text(text = stringResource(R.string.gennre_bold), style = Typography1.h1)
            }

        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center
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
                    Column() {
                        Text(text = "Normal" , color = Color.White , fontSize = 20.sp)

                    }

                }
            }

        }

    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ObesiteResultScreenPreview() {
    ObesiteResult()
}