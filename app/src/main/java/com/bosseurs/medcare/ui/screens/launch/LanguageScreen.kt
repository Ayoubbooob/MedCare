package com.bosseurs.medcare.ui.screens.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
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
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.theme.BlueButtonColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor

@Composable
fun LanguageScreen(modifier: Modifier = Modifier) {
    val lang1 = painterResource(R.drawable.flag_ar )
    val lang2 = painterResource(R.drawable.flag_fr )
    val lang3 = painterResource(R.drawable.flag_en )
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.Choose_language),
            style = MaterialTheme.typography.h4,
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
            color = BlueButtonColor, textColor = TextForBlueButtonColor,
            onClick = { /*TODO*/ }
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
        Text(text = text, style = MaterialTheme.typography.h4)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LanguageScreenPreview() {
    LanguageScreen()
}