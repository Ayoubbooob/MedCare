package com.bosseurs.medcare.ui.screens.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.R


@Composable
fun LaunchScreen(modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.logo )
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = "MedCare's logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LaunchScreenPreview() {
    LaunchScreen()
}
