@file:Suppress("UNUSED_EXPRESSION")

package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.ui.theme.BlueColor



@Composable
fun DayShape(
    dayNum: String,
    dayName: String,
    modifier: Modifier = Modifier,
    color: Color = BlueColor,
    isSelected : Boolean = false,
    onClick : () -> Unit = {},
){
        Card(
            elevation = 30.dp,
            shape = RoundedCornerShape(15.dp),
            backgroundColor = color,
            modifier = Modifier.clickable { onClick }
        ) {
            Column(
                modifier = Modifier.
                padding(vertical = 12.dp, horizontal = 11.dp).
                size(width = 40.dp, height = 42.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(dayNum, fontWeight = FontWeight.W500, color = Color.White, fontSize = 16.sp) //TODO- Poppins font
                Spacer(modifier = Modifier.height(2.dp))
                Text(dayName, fontWeight = FontWeight.W400, color = Color.White, fontSize = 14.sp)
            }

        }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DayShapePreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        DayShape(dayNum = "16", dayName = "Mar", onClick = {})
    }
}
