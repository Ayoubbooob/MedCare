package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.R

@Composable
fun HourShape(
    hour: String,
    amOrPM : String,
    modifier: Modifier = Modifier,
    color: Color = BlueColor,
    isSelected : Boolean = false,
    onClick : () -> Unit,
){
    Card(
        elevation = 30.dp,
        shape = RoundedCornerShape(35.dp),
        backgroundColor = color,
        modifier = Modifier.clickable { onClick }
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 6.dp)
                .size(width = 91.dp, height = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
            Text(hour, fontWeight = FontWeight.W500, color = Color.White, fontSize = 16.sp) //TODO- Poppins font
            Spacer(modifier = Modifier.width(3.dp))
            Text(amOrPM, fontWeight = FontWeight.W400, color = Color.White, fontSize = 14.sp)
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HourShapePreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        HourShape(
            hour = stringResource(id = R.string.eight),
            amOrPM = stringResource(id = R.string.AM),
            onClick = {})
    }
}