package com.bosseurs.medcare.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bosseurs.medcare.ui.screens.appointment.AppointmentScreen
import com.bosseurs.medcare.ui.screens.auth.AuthScreen
import com.bosseurs.medcare.ui.screens.description.DescriptionScreen
import com.bosseurs.medcare.ui.screens.information.InfoDetailScreen
import com.bosseurs.medcare.ui.screens.information.MenuInfoScreen
import com.bosseurs.medcare.ui.screens.launch.LanguageScreen
import com.bosseurs.medcare.ui.screens.login.LoginScreen
import com.bosseurs.medcare.ui.screens.main.HomeScreen
import com.bosseurs.medcare.ui.screens.main.HomeUiState
import com.bosseurs.medcare.ui.screens.main.HomeViewModel
import com.bosseurs.medcare.ui.screens.procedures.ProcedureDetails
import com.bosseurs.medcare.ui.screens.procedures.ProceduresScreen
import com.bosseurs.medcare.ui.screens.profile.ProfileScreen
import com.bosseurs.medcare.ui.screens.signup.SignUpScreen
import com.bosseurs.medcare.ui.utils.Screen
import com.google.gson.Gson
import androidx.navigation.compose.rememberNavController as rememberNavController

@Composable
fun Navigation(toggleTheme : () -> Unit) {
    val navController = rememberNavController()
    NavHost(
    navController = navController,
    startDestination = Screen.LanguageScreen.route
    ) {
        composable(route = Screen.LanguageScreen.route){
            LanguageScreen(navController = navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.DescriptionScreen.route){
            DescriptionScreen(navController = navController)
        }
        composable(route = Screen.AuthScreen.route){
            AuthScreen(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
//        composable(route = Screen.HomeScreen.route)
        composable(
            route = Screen.HomeScreen.route,
            arguments = listOf(
                navArgument("is_user_connected"){type = NavType.BoolType},
                navArgument("username"){type = NavType.StringType},
            )){
            HomeScreen(
                navController = navController,
                isUserConnected = it.arguments?.getBoolean("is_user_connected") == true,
                username = it.arguments?.getString("username").toString()
            )
        }

        composable(
            route = Screen.MenuInfoScreen.route,
            arguments = listOf(
                navArgument("home_ui_state"){type = NavType.StringType}
            )
        ){
            val homeUiStateJson = it.arguments?.getString("home_ui_state").toString()
            val homeUiState = Gson().fromJson(homeUiStateJson, HomeUiState::class.java)
            MenuInfoScreen(navController = navController, homeUiState = homeUiState)
        }

        composable(
            route = Screen.InfoDetailScreen.route,
            arguments = listOf(
                navArgument("title"){type = NavType.StringType},
                navArgument("video_uri"){type = NavType.StringType},
                navArgument("info_content"){type = NavType.StringType}
            )
        ){
            InfoDetailScreen(
                title = it.arguments?.getString("title").toString(),
                videoUri = it.arguments?.getString("video_uri").toString(),
                infoContentMarkdown = it.arguments?.getString("info_content").toString(),
                navController = navController
            )
        }

        composable(route = Screen.AppointmentScreen.route){
            AppointmentScreen(navController = navController)
        }

        composable(route = Screen.ProceduresScreen.route){
            ProceduresScreen(navController = navController)
        }


//        composable(route = Screen.ProcedureDetails.route) { backStackEntry ->
//            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
//            ProcedureDetails(navController = navController, id = id)
//        }

        composable(Screen.ProcedureDetails.route + "/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            if (id != null) {
                ProcedureDetails(navController, id)
            }
        }
    }
}