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
import com.gatepay.signalr_sample.presentation.phonenumber_screen.LoginScreen
import com.gatepay.signalr_sample.presentation.password_screen.PasswordScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.LoginScreen.route) {
        loginScreenRoute(navController)
        passwordScreenRoute(navController)
    }
}


fun NavGraphBuilder.loginScreenRoute(navController: NavController) {
    composable(
        route = Screen.LoginScreen.route,
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
        LoginScreen(navController)
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
