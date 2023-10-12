package com.gatepay.signalr_sample.common.navigation

import com.gatepay.signalr_sample.common.LOGIN_REQUEST_ARGUMENT

sealed class Screen(val route: String) {
    object PhoneNumberScreen : Screen(route = "phone_number_screen")

    object PasswordScreen :
        Screen(route = "password_screen?$LOGIN_REQUEST_ARGUMENT={$LOGIN_REQUEST_ARGUMENT}") {
        fun passLoginRequest(loginRequest: String?) =
            "password_screen?$LOGIN_REQUEST_ARGUMENT=$loginRequest"
    }

    object OnlineFriendsScreen: Screen(route = "online_friends_screen")

//    object OnlineFriendsScreen: Screen(route = "online_friends_screen?$MULTI_LOGIN_RESPONSE_ARGUMENT={$MULTI_LOGIN_RESPONSE_ARGUMENT}") {
//        fun passMultiLoginResponse(multiLoginResponse: String?) =
//            "online_friends_screen?$MULTI_LOGIN_RESPONSE_ARGUMENT=$multiLoginResponse"
//    }

}
