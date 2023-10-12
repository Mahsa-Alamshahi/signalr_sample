package com.gatepay.signalr_sample.presentation.online_friends_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gatepay.signalr_sample.data.data_source.local.LoginEntity
import com.microsoft.signalr.HubConnectionBuilder
import com.orhanobut.logger.Logger
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OnlineFriendsScreen(
    viewModel: OnlineFriendsViewModel = hiltViewModel()
) {


    var isLoading by remember { mutableStateOf(true) }
    val userListState: MutableState<List<LoginEntity>> =
        remember { mutableStateOf(emptyList()) }


    LaunchedEffect(Unit) {
        isLoading = true
        withContext(Dispatchers.IO) {
            userListState.value = viewModel.getUser()
            println("*********************** " + userListState.value)
            isLoading = false
        }
    }


    if (isLoading.not()) {

        if (userListState.value.isNotEmpty()) {

            Column(
                modifier =
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Username: ${userListState.value[0].username} ")
                Text(text = "UserId: ${userListState.value[0].userId} ")

            }

            var hubConnection =
                HubConnectionBuilder.create("http://213.176.29.90:20911/ChatHub/OnConnect")
                    .withAccessTokenProvider(Single.defer {
                        Single.just(
                            "Bearer ${userListState.value[0].chatToken}"
                        )
                    })
                    .build()



//            hubConnection.on(
//                "JoinToHub",
//                Action4 { t1, t2, t3, t4 -> println("***** $t1  $t2 $t3  $t4") },
//                String::class.java, String::class.java, String::class.java, Long::class.java
//            )

            Logger.d(hubConnection.connectionState)
            hubConnection.start()
//                .doOnError {
//                Logger.d("OnError  ==>  ${it.message}")
//            }.doOnComplete {
//                Logger.d("OnCompleted")
//            }
//                .blockingAwait()


            Logger.d(hubConnection.connectionState)



        hubConnection.send(
            "JoinToHub",
            userListState.value[0].chatToken,
            userListState.value[0].username,
            userListState.value[0].password,
            userListState.value[0].userId
        )

        } else {
            Column(
                modifier =
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "User not found.")
            }
        }
    } else {
        Column(
            modifier =
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }

}