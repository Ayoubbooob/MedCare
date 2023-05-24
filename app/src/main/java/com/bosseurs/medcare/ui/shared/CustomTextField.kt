package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.theme.LeadingIconColor
import com.bosseurs.medcare.ui.theme.TextFieldBorderColor
import com.bosseurs.medcare.ui.theme.labelTextStyle

@Composable
fun CustomTextField(
    labelText: Int,
    leadingIconId:Int?,
    iconDescription: String?,
    keyboardType: KeyboardType,
    trailingIconId: Int?,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
){
    TextField(
        value = value,
        onValueChange = onValueChange,

        label = {Text(stringResource(labelText), style = labelTextStyle)} ,
        leadingIcon = if(leadingIconId != null ){
            {Icon(
                painter = painterResource(leadingIconId),
                contentDescription = iconDescription,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )}
        }else{
            null
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType), // ex : keyboardType =  KeyboardType.Number,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = TextFieldBorderColor,
            unfocusedIndicatorColor = TextFieldBorderColor,
            leadingIconColor = LeadingIconColor
        ),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if(trailingIconId != null){
            {Icon(
                painter = painterResource(trailingIconId),
                contentDescription = iconDescription,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )}
        }else{
            null
        },

        )
}

//@Preview(showBackground = true)
//@Composable
//fun CustomTextFieldPreview(){
//    CustomTextField(
//        labelText = R.string.username,
//        leadingIconId = R.drawable.person_icon,
//        iconDescription = "Person Icon" ,
//        keyboardType = KeyboardType.Text,
//        trailingIconId = null,
//        )
//}