package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.ui.theme.BlueButton
import com.bosseurs.medcare.ui.theme.CustomShape
import com.bosseurs.medcare.ui.theme.Shapes
import com.bosseurs.medcare.ui.theme.TextForBlueButton


@Composable
fun CustomButton(
    text : String,
    onClick : () -> Unit,
    color : Color,
    textColor : Color
){
    Button(onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomShape.large,
        modifier = Modifier.size(width = 311.dp,height = 50.dp)
    ) {
        Text("$text" , color = textColor,
            style = MaterialTheme.typography.button
            )

    }
    
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview(){
    CustomButton(text = "CONTINUE", onClick = {}, color = BlueButton, textColor = TextForBlueButton)
}