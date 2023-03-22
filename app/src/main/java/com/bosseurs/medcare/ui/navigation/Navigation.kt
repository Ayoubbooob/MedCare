package com.bosseurs.medcare.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bosseurs.medcare.ui.screens.auth.AuthScreen
import com.bosseurs.medcare.ui.screens.description.DescriptionScreen
import com.bosseurs.medcare.ui.screens.launch.LanguageScreen
import com.bosseurs.medcare.ui.screens.login.LoginScreen
import com.bosseurs.medcare.ui.screens.main.HomeScreen
import com.bosseurs.medcare.ui.screens.signup.SignUpScreen
import com.bosseurs.medcare.ui.utils.Screen
import androidx.navigation.compose.rememberNavController as rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
    navController = navController,
    startDestination = Screen.LanguageScreen.route
    ) {
        composable(route = Screen.LanguageScreen.route){
            LanguageScreen(navController = navController)
        }
        composable(route = Screen.DescriptionScreen.route){
            DescriptionScreen(navController = navController)
        }
        composable(route = Screen.AuthScreen.route){
            AuthScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }

    }
}