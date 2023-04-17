package com.bosseurs.medcare.ui.screens.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen

@Composable
fun LanguageScreen(navController: NavController,modifier: Modifier = Modifier) {
    val lang1 = painterResource(R.drawable.flag_ar )
    val lang2 = painterResource(R.drawable.flag_fr )
    val lang3 = painterResource(R.drawable.flag_en )
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.Choose_language),
            style = Typography1.h1,
            textAlign = TextAlign.Center
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                LangImage(image = lang1, text = stringResource(R.string.language_1))
                LangImage(image = lang2, text = stringResource(R.string.language_2))
            }
            LangImage(image = lang3, text = stringResource(R.string.language_3))
        }
        CustomButton(textId = R.string.continue_label ,
            color = BlueColor, textColor = TextForBlueButtonColor,
            onClick = {
                navController.navigate(Screen.DescriptionScreen.route)
            }
        )
    }
}

@Composable
fun LangImage(image: Painter, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "language icon",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(150.dp)
        )
         Text(text = text, style = Typography1.h1)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LanguageScreenPreview() {
    CustomButton(textId = R.string.continue_label ,
            color = BlueColor, textColor = TextForBlueButtonColor,
            onClick = {
                //navController.navigate(Screen.DescriptionScreen.route)
            }
        )
}