package com.bosseurs.medcare.ui.utils

import androidx.annotation.DimenRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle

data class  ImageModel(
    val path: ImageVector,
    val dimenRes: DimenRes,
    val style: FontStyle,
    val modifier: Modifier,
    val contenteDescription : String
)
