package com.bosseurs.medcare.ui.shared

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bosseurs.medcare.ui.utils.BlockModel

@Composable

fun CustomBlocksScreen(
    navController: NavController,
    blocksList : List<BlockModel>,
    toggleTheme: () -> Unit = {}
){
    LazyColumn {
        item {
            BlocksTopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(blocksList) {
            blocksList.forEach {
                BlockCard(
                    it,
                    onItemClicked = {
                        //TODO - when a block choosed
//                            block ->
//                        navController.navigate("details/${block.id}/${block.name}/${block.location}")
                    }
                )
            }
        }
    }

}