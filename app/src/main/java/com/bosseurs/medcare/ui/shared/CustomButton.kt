package com.bosseurs.medcare.ui.shared
import androidx.compose.foundation.layout.padding
import com.bosseurs.medcare.R
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.theme.BlueButtonColor
import com.bosseurs.medcare.ui.theme.CustomShape
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor


@Composable
fun CustomButton(
    textId : Int,
    onClick : () -> Unit,
    color : Color,
    textColor : Color
){
    Button(onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomShape.large,
        modifier = Modifier.size(width = 311.dp,height = 50.dp)
    ) {
        Text(
            stringResource(textId) , color = textColor,
            style = MaterialTheme.typography.button
            )

    }
    
}

@Composable
fun CustomButtonIcons(
    textId : Int,
    icon: Painter,
    onClick : () -> Unit,
    color : Color,
    textColor : Color
){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomShape.large,
        modifier = Modifier.size(width = 311.dp,height = 50.dp)
    ) {
        Icon(
            painter = icon ,
            contentDescription = "icon",
            modifier = Modifier.padding(end=10.dp)
        )
        Text(
            text = stringResource(textId) , color = textColor,
            style = MaterialTheme.typography.button
        )

    }

}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview(){
    CustomButton(textId = R.string.CONTINUE, onClick = {}, color = BlueButtonColor, textColor = TextForBlueButtonColor)
}