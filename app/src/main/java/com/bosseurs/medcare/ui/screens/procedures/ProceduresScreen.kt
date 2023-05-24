package com.bosseurs.medcare.ui.screens.procedures

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bosseurs.medcare.data.FakeBlockDatabase
import com.bosseurs.medcare.ui.shared.CustomBlocksScreen
import com.bosseurs.medcare.ui.shared.CustomTopAppBar
import com.bosseurs.medcare.ui.shared.FooterBarInstance


@Composable
fun ProceduresScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomTopAppBar(
            onClick = { navController.popBackStack() },
        ) },
    ) {
        CustomBlocksScreen(
            navController = navController,
            blocksList = FakeBlockDatabase.proceduresBlocksList,

            )
    }
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
