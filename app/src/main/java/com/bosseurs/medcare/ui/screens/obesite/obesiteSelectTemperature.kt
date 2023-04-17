package com.bosseurs.medcare.ui.screens.obesite

import android.content.Context
import android.provider.Settings.Global.getString
import android.widget.NumberPicker
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.shared.VerticalNumberPicker
import com.bosseurs.medcare.ui.theme.*

@Composable
fun ObesiteSelectTemperature(){
    Column {
        val context = LocalContext.current
        Column(
            modifier = Modifier.layoutId("picker"),
            horizontalAlignment = CenterHorizontally
        ) {

            //Text(
                //text = getString(R.string.vertical_picker),
                //modifier = Modifier.width(IntrinsicSize.Max).align(CenterHorizontally))
            VerticalNumberPicker(
                min = 20,
                max=30,
                default = 20
            )
        }


    }
}

fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun CustomObesiteTemperatturePreview(){
    ObesiteSelectTemperature()
}

