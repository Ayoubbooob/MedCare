
package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import  com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.utils.enums.ImportanceLevel

@Composable
fun ImportanceLevelTag(importanceLevel: ImportanceLevel) {
//    val color = if (name == "Male") R.color.blue else R.color.red

    val color = when (importanceLevel) {
        ImportanceLevel.URGENT -> R.color.red
        ImportanceLevel.PASURGENT -> R.color.blue
        ImportanceLevel.IMPORTANT -> R.color.green
        ImportanceLevel.PASIMPORTANT -> R.color.yellow
        else -> {
            R.color.blue
        }
    }


    ChipView(importanceLevel = importanceLevel, colorResource = colorResource(id = color))
}

@Composable
fun ChipView(importanceLevel: ImportanceLevel, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = importanceLevel.toString(), modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}
