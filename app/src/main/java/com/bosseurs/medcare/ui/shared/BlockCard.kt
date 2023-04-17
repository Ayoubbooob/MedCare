
package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.data.FakeBlockDatabase
import com.bosseurs.medcare.ui.utils.BlockModel

@Composable
fun BlockCard(block: BlockModel, onItemClicked: (block: BlockModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(block) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val image: Painter = painterResource(id = block.image)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "Image describe the block",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = block.title,
                    modifier = Modifier.padding(0.dp, 0.dp, 5.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    ImportanceLevelTag(importanceLevel = block.importanceLevel)
                }

                //                Text(
                //                    text = buildString {
                //                        append(block.age)
                //                        append("yrs | ")
                //                        append(block.gender)
                //                    },
                //                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                //                    color = MaterialTheme.colors.surface,
                //                    style = typography.caption
                //                )

                //                Row(verticalAlignment = Alignment.Bottom) {
                //
                ////                    val location: Painter = painterResource(id = R.drawable.ic_location)
                ////
                ////                    Icon(
                ////                        painter = location,
                ////                        contentDescription = null,
                ////                        modifier = Modifier.size(16.dp, 16.dp),
                ////                        tint = Color.Red
                ////                    )
                ////
                ////                    Text(
                ////                        text = block.location,
                ////                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                ////                        color = MaterialTheme.colors.surface,
                ////                        style = typography.caption
                ////                    )
                //                }
            }

        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BlockCardPreview(){
    val bloc = FakeBlockDatabase.proceduresBlocksList[0];
    BlockCard(block = bloc, onItemClicked = {})
}