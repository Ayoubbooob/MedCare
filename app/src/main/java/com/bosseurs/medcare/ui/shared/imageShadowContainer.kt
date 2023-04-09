package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.screens.auth.AuthScreen
import com.bosseurs.medcare.ui.utils.ImageModel

@Composable
fun ImageShadowContainer(
    modifier: Modifier = Modifier,
    color: Color,
    contente : ImageModel
    //symbol: String,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color)
            .then(modifier)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(fraction = 0.8f)
                .shadow(
                    color = MaterialTheme.colors.onSecondary ,
                    offsetX = 0.dp,
                    offsetY = 22.dp,
                    blurRadius = 14.dp,
                )
                .clip(MaterialTheme.shapes.medium)
                .background(color)
        ) {
            //image ressource
            //you have to use image container however
            ImageContainer(image = contente )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthScreenPreview() {
    val image = painterResource(R.drawable.welcome_img )
    val imageModelInstance = ImageModel(
        path = image ,
        size = 200 ,
        contenteDescription = "Genre Image" ,
    )
    ImageShadowContainer(color = MaterialTheme.colors.onPrimary , modifier = Modifier.height(232.dp).width(297.dp).size(100.dp) , contente = imageModelInstance)
}