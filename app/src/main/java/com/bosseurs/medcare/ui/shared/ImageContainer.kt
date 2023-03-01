package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.bosseurs.medcare.ui.utils.ImageModel


//ImageContainer(image)
//image est de type ImageModel dont vous pouvez voir la structure dans utils

@Composable
fun ImageContainer(image: ImageModel){
    Row(modifier = image.modifier) {
        Column(modifier = image.modifier) {
            Image(imageVector = image.path,
                contentDescription = image.contenteDescription ,
                modifier = image.modifier ,
            )
        }
    }

}