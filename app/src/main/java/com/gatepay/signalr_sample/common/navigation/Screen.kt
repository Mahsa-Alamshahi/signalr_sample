package com.gatepay.signalr_sample.common.navigation

sealed class Screen(val route: String){
    object LoginScreen: Screen(route = "login_screen")
    object PasswordScreen: Screen(route = "password_screen")

}
