package com.bosseurs.medcare.ui.theme

import android.text.style.LineHeightSpan
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.R
import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle.FontSizeUnit

val robot = FontFamily(
    Font(R.font.overpass_regular)
)
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
        fontSize = 20.sp,
        color = Color(0XFF090F47)
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,                      /* This is For Big text, in our app like the title" Tout savoir sur l'obésité " */
        fontSize = 30.sp,
        color = Color(0XFF090F47)
    ),


    subtitle1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,                      /* This is For Big text, in our app like the title" Tout savoir sur l'obésité " */
        fontSize = 30.sp,
        color = Color(0XFF090F47)

    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,                      /* This is For Big text, in our app like the title" Tout savoir sur l'obésité " */
        fontSize = 30.sp,
        color = Color(0XFF090F47)

    ),



    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
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

val poppins = FontFamily(
    Font(R.font.poppins),
)
val AppBarTextStyle = TextStyle(
    fontFamily = poppins,
    color = TopAppBarTitleColor,
    fontSize = 21.sp,
    fontWeight = FontWeight.W500
)

val AppointmentBigTextStyle = TextStyle(
    fontFamily = poppins,
    color = Color.Black,
    fontWeight = FontWeight.W600,
    fontSize = 27.sp,
)