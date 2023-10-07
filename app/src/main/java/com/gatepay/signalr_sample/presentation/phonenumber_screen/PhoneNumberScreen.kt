package com.gatepay.signalr_sample.presentation.phonenumber_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.common.navigation.NavArgJsonConverter.toJson
import com.gatepay.signalr_sample.common.navigation.Screen
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.orhanobut.logger.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: PhoneNumberViewModel = hiltViewModel()) {

    var phoneNumberText by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
//    val state by viewModel.state
    val getAllUserData = viewModel.getResponse.observeAsState()
    val context = LocalContext.current

    Column(
        modifier =
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all =
                    12.dp
                ),
            value = phoneNumberText,
            onValueChange = { phoneNumberText = it },
            label = { Text("Phone Number") }
        )
        Button(
            onClick = {

                val request = LoginAndRegisterRequest(
                    checkPrivateNumber = false,
                    parentId = "2",
                    domainName = "213.176.29.90",
                    password = "",
                    userName = phoneNumberText
                )
                lateinit var response: LoginAndRegisterResponse
                runBlocking {
                    val job = launch {
                        response = viewModel.loginAndRegister(request)
                    }
                    job.join()
                }
                if (response.result == "OK") {
                    val loginRequestString = request.toJson()
                    navController.navigate(Screen.PasswordScreen.passLoginRequest(loginRequestString))
                } else {
                    Toast.makeText(context, response.message!!, Toast.LENGTH_SHORT).show()
                }

            },
            Modifier
                .fillMaxWidth()
                .padding(
                    all =
                    12.dp
                ),
        ) {
            Text("Register")
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController)
}