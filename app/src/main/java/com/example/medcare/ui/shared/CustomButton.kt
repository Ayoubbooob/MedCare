package com.example.medcare.ui.shared
import com.example.medcare.R
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medcare.ui.theme.BlueButtonColor
import com.example.medcare.ui.theme.CustomShape
import com.example.medcare.ui.theme.TextForBlueButtonColor


@Composable
fun CustomButton(
    textId : Int,
    onClick : () -> Unit,
    color : Color,
    textColor : Color,
    modifier: Modifier = Modifier
){
    Button(onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomShape.large,
        modifier = modifier.size(width = 311.dp,height = 50.dp)
    ) {
        Text(
            stringResource(textId) , color = textColor,
            style = MaterialTheme.typography.button
            )

    }
    
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview(){
    CustomButton(textId = R.string.CONTINUE, onClick = {}, color = BlueButtonColor, textColor = TextForBlueButtonColor)
}