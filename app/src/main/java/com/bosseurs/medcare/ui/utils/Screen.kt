package com.bosseurs.medcare.ui.utils

sealed class Screen(val route : String){
    object LanguageScreen : Screen("language_screen")
    object DescriptionScreen : Screen("description_screen")
    object AuthScreen : Screen("auth_screen")
    object SignUpScreen : Screen("signup_screen")
    object LoginScreen : Screen("login_screen")
    object PhoneVerifiedScreen : Screen("phone_verified_screen")
    object HomeScreen : Screen("home_screen")

    object InfoObesityScreen: Screen("info_obesity_screen")
    object InfoDiabeteScreen: Screen("info_diabete_screen")
    object MenuInfoScreen: Screen("menu_info_screen")

}
