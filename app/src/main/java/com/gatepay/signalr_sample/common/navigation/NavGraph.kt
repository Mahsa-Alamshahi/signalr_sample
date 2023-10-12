package com.gatepay.signalr_sample.common.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gatepay.signalr_sample.common.LOGIN_REQUEST_ARGUMENT
import com.gatepay.signalr_sample.common.navigation.NavArgJsonConverter.fromJson
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.presentation.online_friends_screen.OnlineFriendsScreen
import com.gatepay.signalr_sample.presentation.password_screen.PasswordScreen
import com.gatepay.signalr_sample.presentation.phonenumber_screen.PhoneNumberScreen

@Composable
fun NavGraph(navController: NavHostController, startDest: String) {


    NavHost(navController, startDestination = startDest) {
        loginScreenRoute(navController)
        passwordScreenRoute(navController)
        onlineFriendsScreenRoute()
    }
}


fun NavGraphBuilder.loginScreenRoute(navController: NavController) {
    composable(
        route = Screen.PhoneNumberScreen.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
    ) {
        PhoneNumberScreen(navController)
    }
}

fun NavGraphBuilder.passwordScreenRoute(navController: NavController) {
    composable(
        route = Screen.PasswordScreen.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        arguments = listOf(navArgument(LOGIN_REQUEST_ARGUMENT) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->

        navBackStackEntry.arguments?.getString(LOGIN_REQUEST_ARGUMENT)
            ?.let { jsonString ->
                val loginRequest = jsonString.fromJson(LoginAndRegisterRequest::class.java)
                PasswordScreen(navController, loginRequest)
            }
    }
}


fun NavGraphBuilder.onlineFriendsScreenRoute() {
    composable(
        route = Screen.OnlineFriendsScreen.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
    ) {
        OnlineFriendsScreen()
    }
}

