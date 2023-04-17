package com.bosseurs.medcare.ui.utils

sealed class Screen(val route : String){
    object LanguageScreen : Screen("language_screen")
    object DescriptionScreen : Screen("description_screen")
    object AuthScreen : Screen("auth_screen")
    object SignUpScreen : Screen("signup_screen")
    object LoginScreen : Screen("login_screen")
    object PhoneVerifiedScreen : Screen("phone_verified_screen")
    object HomeScreen : Screen("home_screen")
    object AppointmentScreen : Screen("appointment_screen")

    object InfoObesityScreen: Screen("info_obesity_screen")
    object MenuInfoScreen: Screen("menu_info_screen")
    object ObesiteGenreScreen: Screen("obesite_genre_screen")

}
