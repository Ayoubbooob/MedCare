package com.bosseurs.medcare.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun PhoneVerified(navController: NavController = rememberNavController(),modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.tick_icon )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 60.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .align(alignment = Alignment.Start)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "back"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.5f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "tick image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(170.dp)
            )
            Text(text = stringResource(R.string.phone_verified), style = Typography1.h1)
            Text(text = stringResource(R.string.phone_verified_details),
                textAlign = TextAlign.Center,
                style = Typography1.caption
            )
        }

        CustomButton(textId = R.string.continue_label,
            color = BlueColor, textColor = TextForBlueButtonColor,
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhoneVerifiedPreview() {
    PhoneVerified()
}