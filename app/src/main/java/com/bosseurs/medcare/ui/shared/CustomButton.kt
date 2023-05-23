package com.bosseurs.medcare.ui.shared
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.CustomShape
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

@Composable
fun Dp.DpTopx() = with(LocalDensity.current) {
    this@DpTopx.toPx()
}
@Composable
fun CustomButton(
    textId : Int,
    onClick : () -> Unit,
    color : Color,
    textColor : Color,
    modifier: Modifier = Modifier ,
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


//I do that because ayoub didn't let me to customize the size he hardcode the size of this button
//and I can't change because a bunch of code this button
@Composable
fun CustomButtonObesite(
    textId : Int,
    onClick : () -> Unit,
    color : Color,
    textColor : Color,
    modifier: Modifier = Modifier ,
    CustomWidth : Int ,
    CustomHeight : Int
){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomShape.large,
        modifier = modifier.size(width =CustomWidth.dp,height = CustomHeight.dp)
    ) {
        Text(
            stringResource(textId) , color = textColor,
            //style = MaterialTheme.typography.button
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
        Image(
            painter = icon,
            contentDescription = "icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(end=10.dp)
                .size(30.dp)
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
    CustomButtonObesite(textId = R.string.CONTINUE, onClick = {}, color = BlueColor,
        textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)
}