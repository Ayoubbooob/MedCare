package com.bosseurs.medcare.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.shared.CustomButtonIcons
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.TextForWhiteButtonColor
import com.bosseurs.medcare.ui.theme.WhiteColor
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun AuthScreen(navController: NavController,modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.welcome_img )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val icon = painterResource(id = R.drawable.google_logo_icon)
        Image(
            painter = image,
            contentDescription = "welcome image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(200.dp)
        )
        Text(text = stringResource(R.string.message_bienvenue), style = MaterialTheme.typography.h4)
        Text(text = stringResource(R.string.sous_message_bienvenue),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        CustomButton(textId = R.string.register_email, color = BlueColor, textColor = TextForBlueButtonColor,
            onClick = {
                navController.navigate(Screen.SignUpScreen.route)
            }
        )
        CustomButtonIcons(textId = R.string.register_gmail, icon = icon, color = WhiteColor, textColor = TextForWhiteButtonColor,
            onClick = { /*TODO*/ }
        )
        CustomButton(textId = R.string.continue_without_connexion, color = WhiteColor, textColor = TextForWhiteButtonColor,
            onClick = { /*TODO*/ }
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun AuthScreenPreview() {
//    AuthScreen()
//}