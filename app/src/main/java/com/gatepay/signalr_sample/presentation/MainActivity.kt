package com.gatepay.signalr_sample.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gatepay.signalr_sample.common.navigation.NavGraph
import com.gatepay.signalr_sample.common.navigation.Screen
import com.gatepay.signalr_sample.common.ui.theme.SingleRTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val viewModel: MainViewModel by viewModels()
    private var isUserExisted = false


    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SingleRTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    runBlocking {
                        withContext(Dispatchers.IO) {
                            isUserExisted = viewModel.isUserExisted()
                        }
                    }

                    if (isUserExisted) {
                        NavGraph(
                            navController = navController,
                            startDest = Screen.OnlineFriendsScreen.route
                        )
                    } else {
                        NavGraph(
                            navController = navController, startDest = Screen.PhoneNumberScreen.route
                        )
                    }
                }
            }
        }
    }

}


