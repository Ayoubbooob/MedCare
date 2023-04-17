package com.bosseurs.medcare.ui.screens.procedures

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bosseurs.medcare.data.FakeBlockDatabase
import com.bosseurs.medcare.ui.shared.CustomBlocksScreen


@Composable
fun ProceduresScreen(navController: NavController) {
    CustomBlocksScreen(navController = navController, blocksList = FakeBlockDatabase.proceduresBlocksList)
}

//@Composable
//@Preview(showBackground = true, showSystemUi = true)
//fun ProceduresScreenPreview(){
//    val navController = rememberNavController()
//    val proceduresBlocList = FakeBlockDatabase.blockList
//
//
//    val toggleTheme :  () -> Unit = {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//    }
//
//    ProceduresScreen(navController, proceduresBlocList, toggleTheme)
//
//
//
//}
