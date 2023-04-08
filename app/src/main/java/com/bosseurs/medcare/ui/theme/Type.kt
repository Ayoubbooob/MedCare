package com.bosseurs.medcare.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.R


val Overpass = FontFamily(
    Font(R.font.overpass_regular),
//        Font(R.font.overpass_bold)
)

// Set of Material typography styles to start with
val Typography1 = Typography(
    Overpass, //This is font has been used for all components in figma
    //You have to specify h1, h2, ... , it depends on your need
    h1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W700,                      /* This is For Big text, in our app like the title" Tout savoir sur l'obésité " */
        fontSize = 30.sp,
        color = Color(0XFF090F47)
    ),
    h2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W700,                      /* This is For Big text, in our app like the title" Tout savoir sur l'obésité " */
        fontSize = 30.sp,
        color = Color(0XFF090F47)
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),



    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W700,
        fontSize = 21.sp,
    ),


    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W300,                  /* This is for description text */
        fontSize = 16.sp,
        color = Color(0XFFc0c2d0)
    )

)

val arial = FontFamily(
    Font(R.font.arial)
)
val labelTextStyle = TextStyle(
    fontFamily = arial,
    color = labelTextColor,
    fontSize = 20.sp,
    fontWeight = FontWeight.W400
)

