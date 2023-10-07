package com.gatepay.signalr_sample.common.navigation

import com.gatepay.signalr_sample.common.LOGIN_REQUEST_ARGUMENT

sealed class Screen(val route: String){
    object LoginScreen: Screen(route = "login_screen")
    object PasswordScreen: Screen(route = "password_screen?$LOGIN_REQUEST_ARGUMENT={$LOGIN_REQUEST_ARGUMENT}")
    {
        fun passLoginRequest(loginRequest: String?) =
            "password_screen?$LOGIN_REQUEST_ARGUMENT=$loginRequest"
    }

}
