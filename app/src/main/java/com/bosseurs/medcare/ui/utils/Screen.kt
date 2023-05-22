package com.bosseurs.medcare.ui.utils

import com.bosseurs.medcare.ui.screens.main.HomeViewModel

sealed class Screen(val route : String){
    object LanguageScreen : Screen("language_screen")
    object DescriptionScreen : Screen("description_screen")
    object AuthScreen : Screen("auth_screen")
    object ProfileScreen : Screen("profile_screen")
    object SignUpScreen : Screen("signup_screen")
    object LoginScreen : Screen("login_screen")
    object obesiteGenre : Screen("obesiteGenre_screen")
    object obesiteTaille : Screen("obesiteTaille_screen")
    object obesitePoid : Screen("obesitePoid_screen")
    object obesiteResult : Screen("obesiteResult_screen")
    object PhoneVerifiedScreen : Screen("phone_verified_screen")
    object HomeScreen : Screen("home_screen/{is_user_connected}/{username}"){
        fun passArgs(isUserConnected: Boolean, username: String = "") : String{
            return "home_screen/$isUserConnected/$username"
        }
    }

    object MenuInfoScreen: Screen("menu_info_screen/{home_ui_state}"){
        fun passArgs(homeUiStateJson: String) : String{
            return "menu_info_screen/$homeUiStateJson"
        }
    }
    object InfoDetailScreen: Screen("info_detail_screen/{title}/{video_uri}/{info_content}"){
        fun passArgs(title: String, videoUri: String, infoContentMarkdown: String,) : String{
            return "info_detail_screen/$title/$videoUri/$infoContentMarkdown"
        }
    }
    object AppointmentScreen : Screen("appointment_screen")
    object ProceduresScreen : Screen("procedures_screen")
    object ProcedureDetails : Screen("procedures_details")

<<<<<<< HEAD
=======
    object MenuInfoHospitalScreen : Screen("menu_info_hospital_screen")
    object HospitalInfoScreen : Screen("hospital_info_screen")

    object BariaticServiceScreen : Screen("bariatic_service_screen")




>>>>>>> 54f04ee79efb2a531c29198da057f24352db8e53
}
