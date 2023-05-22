package com.bosseurs.medcare.ui.screens.launch

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
<<<<<<< HEAD
=======
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
>>>>>>> 54f04ee79efb2a531c29198da057f24352db8e53
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.CustomButton
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import com.bosseurs.medcare.ui.utils.Screen
import java.util.*

@Composable
fun LanguageScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    languageViewModel: LanguageViewModel = viewModel()
) {
    val languageUiState by languageViewModel.uiState.collectAsState()
    val lang1 = painterResource(R.drawable.flag_ar )
    val lang2 = painterResource(R.drawable.flag_fr )
    val lang3 = painterResource(R.drawable.flag_en )

    //language setting
    Locale.setDefault(languageUiState.locale)
    val configuration = LocalConfiguration.current
    configuration.setLocale(languageUiState.locale)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        configuration.setLocale(languageUiState.locale)
    else
        configuration.locale = languageUiState.locale
    var resources = LocalContext.current.resources
    resources.updateConfiguration(configuration, resources.displayMetrics)

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
                LangImage(
                    image = lang1,
                    text = stringResource(R.string.language_1),
                    languageViewModel = languageViewModel,
                    locale = Locale("ar"),
                    onClick = {languageViewModel.updateLocale(Locale("ar"))}
                )
                LangImage(
                    image = lang2,
                    text = stringResource(R.string.language_2),
                    languageViewModel = languageViewModel,
                    locale = Locale("fr"),
                    onClick = {languageViewModel.updateLocale(Locale("fr"))}
                )
            }
            LangImage(
                image = lang3,
                text = stringResource(R.string.language_3),
                languageViewModel = languageViewModel,
                locale = Locale("en"),
                onClick = {languageViewModel.updateLocale(Locale("en"))}
            )
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
fun LangImage(
    image: Painter,
    text: String,
    modifier: Modifier = Modifier.padding(5.dp),
    onClick: () -> Unit = {},
    locale : Locale = Locale("fr"),
    languageViewModel: LanguageViewModel = viewModel()

) {
    var color = MaterialTheme.colors.background
    val languageUiState by languageViewModel.uiState.collectAsState()
    if(languageUiState.locale == locale) color = Color(0XFF090F47)
    Card(
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(2.dp, color),
        shape = RoundedCornerShape(18.dp),
        modifier = modifier
            .clickable(
                enabled = true,
                onClickLabel = "Clickable image",
                onClick = onClick
            ),
    ) {
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