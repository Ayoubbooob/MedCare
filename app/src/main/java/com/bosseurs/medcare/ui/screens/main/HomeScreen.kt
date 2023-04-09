package com.bosseurs.medcare.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.FooterBarInstance
import com.bosseurs.medcare.ui.shared.SearchBare
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen


@Composable
fun HomeScreen(navController: NavController,
               modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Scaffold(
        topBar = {Header()},
        bottomBar = { FooterBarInstance(navController)}
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = stringResource(R.string.cat_principale),
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
                        backImage = painterResource(id = R.drawable.card_img1),
                        onClick = {
                            Toast
                                .makeText(context, "cette route n'est pas encore disponible", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                }
                item {
                    MyCard(
                        backImage = painterResource(id = R.drawable.card_img2),
                        onClick = {
                            navController.navigate(Screen.MenuInfoScreen.route)
                        }
                    )
                }
                item {
                    MyCard(
                        backImage = painterResource(id = R.drawable.card_img2),
                        onClick = {
                            Toast
                                .makeText(context, "cette route n'est pas encore disponible", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                }
                item {
                    MyCard(
                        backImage = painterResource(id = R.drawable.card_img1),
                        onClick = {
                            Toast
                                .makeText(context, "cette route n'est pas encore disponible", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun Header(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(210.dp)
            //.padding(bottom = 30.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10))
                .background(Color(0xFF4157FF))
                .border(
                    1.dp,
                    Color.Black,
                    //shape = RoundedCornerShape(bottomStartPercent = 40, bottomEndPercent = 40),
                )
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Icon(
                    painter = painterResource(R.drawable.profil_image),
                    contentDescription = "profil_image",
                    //contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(1.dp, Color.White, CircleShape)   // add a border (optional)
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
                    text = stringResource(R.string.greeting_homescreen),
                    color = Color.White,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = stringResource(R.string.welcome_homescreen),
                    color = Color.White,
                )
            }
        }
        SearchBarContainer()
    }
}

@Composable
fun MyCard(modifier: Modifier = Modifier,
           backImage: Painter = painterResource(R.drawable.card_img1),
           onClick: () -> Unit = {}
) {
    Card(
        elevation = 10.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 14.dp, vertical = 6.dp)
            .clickable(
                enabled = true,
                onClickLabel = "Clickable image",
                onClick = onClick
            ),
    ) {
        Image(
            painter = backImage,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
        )
        /*Box {
            Image(
                painter = backImage,
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
            Text(text = cardText,
            modifier = modifier
                .align(Alignment.Center)
                .padding(start = 10.dp)
            )
        }*/
    }
}

@Composable
fun SearchBarContainer(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 150.dp, start = 25.dp, end = 25.dp)
        .shadow(AppBarDefaults.BottomAppBarElevation)
        .zIndex(5f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBare(CustumText = stringResource(R.string.search_bar_text))
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}