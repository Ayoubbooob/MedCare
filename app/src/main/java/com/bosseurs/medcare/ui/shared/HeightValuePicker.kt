package com.bosseurs.medcare.ui.shared

/*
 * Copyright © Marc Auberer 2021-2022. All rights reserved
 */


import android.widget.NumberPicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bosseurs.medcare.R

@Preview(name = "Vertical number picker")
@Composable
fun VerticalNumberPicker(
    modifier: Modifier = Modifier,
    width: Dp = 45.dp,
    min: Int = 0,
    max: Int = 10,
    default: Int = min,
    onValueChange: (Int) -> Unit = {},
) {
    var number by remember { mutableStateOf(default) }

    Column {
        PickerButton(
            size = width,
            drawable = R.drawable.ic_arrow_up,
            enabled = number < max,
            onClick = {
                if (number < max) number++
                onValueChange(number)
            }
        )
        Text(
            text = number.toString(),
            fontSize = (width.value / 2).sp,
            modifier = Modifier
                .padding(10.dp)
                .width(IntrinsicSize.Max)
                .align(CenterHorizontally)
        )
        PickerButton(
            size = width,
            drawable = R.drawable.ic_arrow_down,
            enabled = number > min,
            onClick = {
                if (number > min) number--
                onValueChange(number)
            }
        )
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun CustomObesiteTemperatturePreview(){
    VerticalNumberPicker()
}