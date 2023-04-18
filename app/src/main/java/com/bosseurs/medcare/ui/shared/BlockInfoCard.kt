
package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bosseurs.medcare.ui.utils.BlockModel
@Composable
fun BlockInfoCard(block :  BlockModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = block.title,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                ImportanceLevelTag(importanceLevel = block.importanceLevel)

//                val locationIcon: Painter = painterResource(id = R.drawable.ic_location)
//
//                Icon(
//                    painter = locationIcon,
//                    contentDescription = null,
//                    modifier = Modifier.size(16.dp, 16.dp),
//                    tint = Color.Red
//                )

//                Text(
//                    text = location,
//                    modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
//                    color = MaterialTheme.colors.surface,
//                    style = MaterialTheme.typography.caption
//                )
            }

            Spacer(modifier = Modifier.height(16.dp))

//            Text(
//                text = "12 mins ago",
//                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
//                color = MaterialTheme.colors.surface,
//                style = MaterialTheme.typography.overline
//            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(
                text = block.dateAdded,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.overline
            )
        }
    }
}
