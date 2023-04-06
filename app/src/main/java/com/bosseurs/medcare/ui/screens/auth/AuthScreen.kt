package com.bosseurs.medcare.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.bosseurs.medcare.ui.shared.CustomButtonIcons
import com.bosseurs.medcare.ui.theme.*
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun AuthScreen(navController: NavController,modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.welcome_img )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val icon = painterResource(id = R.drawable.google_logo_icon)
        Spacer(
            modifier = Modifier
                .weight(0.1f)
        )
        Column(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .fillMaxHeight()
                .wrapContentHeight(align = Alignment.CenterVertically)
        ) {
            Image(
                painter = image,
                contentDescription = "welcome image",
                modifier = Modifier.fillMaxSize(0.7f)
            )
        }

        Column(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxSize(),
            Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.message_bienvenue), style = Typography1.h1)
            Text(
                text = stringResource(R.string.sous_message_bienvenue),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp),
                style = Typography1.caption
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.05f)
        )

        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize(),
            Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(textId = R.string.register_email,
                color = BlueColor,
                textColor = TextForBlueButtonColor,
                onClick = {
                    navController.navigate(Screen.SignUpScreen.route)
                }
            )
            CustomButtonIcons(textId = R.string.register_gmail,
                icon = icon,
                color = WhiteColor,
                textColor = TextForWhiteButtonColor,
                onClick = { /*TODO*/ }
            )
            CustomButton(textId = R.string.continue_without_connexion,
                color = WhiteColor,
                textColor = TextForWhiteButtonColor,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen( rememberNavController())
}