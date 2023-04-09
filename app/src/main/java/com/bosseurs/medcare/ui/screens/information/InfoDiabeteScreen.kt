package com.bosseurs.medcare.ui.screens.information

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R

@Composable
fun InfoDiabeteScreen(navController: NavController = rememberNavController()) {
    InfoContent(
        INFO_CONTENT = INFO_DIABETE,
        videoUri = "GUxg-MsE-y0",
        title = stringResource(R.string.titre_info_diabete)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InfoDiabeteScreenPreview() {
    InfoDiabeteScreen()
}