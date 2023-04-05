package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SearchBare(CustumText : String ) {
    val query = remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier
        .fillMaxWidth(fraction = 1f)) {
        TextField(value = query.value ,
            onValueChange ={
                query.value = it
            } ,
            label = { Text(text = CustumText ,
                fontWeight= FontWeight(400) ,
                fontSize = 17.33.sp ,
                fontStyle = FontStyle.Normal,
                lineHeight = 21.89.sp ,
                color = Color(red = 9, blue = 15, green = 71, alpha = 45)
            ) } ,
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .clip(CircleShape) ,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "this is the image lead icon" )
            } ,
            colors = TextFieldDefaults.textFieldColors(
                //disabledTextColor = androidx.compose.ui.graphics.Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent ,
                trailingIconColor = Color.Transparent,
                disabledTrailingIconColor = Color.Transparent

            ) ,
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSurface ,
                textDecoration = TextDecoration.None ,
                fontSize = 15.sp ,
                background = MaterialTheme.colors.surface

            ) ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text ,
                imeAction = ImeAction.Search
            )
        )
        LazyColumn{}
    }
}
