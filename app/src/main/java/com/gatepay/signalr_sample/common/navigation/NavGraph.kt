package com.gatepay.signalr_sample.common.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gatepay.signalr_sample.presentation.LoginScreen
import com.gatepay.signalr_sample.presentation.PasswordScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.LoginScreen.route) {
        loginScreenRoute(navController)

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
    ) {
        PasswordScreen(navController)
    }
}
