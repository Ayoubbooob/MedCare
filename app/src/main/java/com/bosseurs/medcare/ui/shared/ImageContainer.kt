package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.utils.ImageModel


//ImageContainer(image)
//image est de type ImageModel dont vous pouvez voir la structure dans utils

@Composable
fun ImageContainer(image: ImageModel){
            Image(
                painter = image.path,
                contentDescription = image.contenteDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(image.size.dp)
                    .clip(CircleShape)
            )
}