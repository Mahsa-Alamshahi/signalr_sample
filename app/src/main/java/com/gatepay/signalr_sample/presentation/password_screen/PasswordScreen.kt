package com.gatepay.signalr_sample.presentation.password_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gatepay.signalr_sample.R
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.common.navigation.Screen
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import kotlinx.coroutines.launch




@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PasswordScreen(
    navController: NavController,
    loginRequest: LoginAndRegisterRequest,
    viewModel: PasswordViewModel = hiltViewModel()
) {


    var password = ""
    val context = LocalContext.current

    var firstDigit by remember { mutableStateOf("") }
    var secondDigit by remember { mutableStateOf("") }
    var thirdDigit by remember { mutableStateOf("") }
    var forthDigit by remember { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    val focusManager = LocalFocusManager.current
    val (first, second, third, forth, btn) = FocusRequester.createRefs()



    Column(
        modifier =
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier =
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {

            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = 12.dp)
                    .focusRequester(first)
                    .focusProperties {
                        next = second
                    },
                value = firstDigit,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    firstDigit = it
                    if (it.length == 1) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                },
            )
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = 12.dp)
                    .focusRequester(second)
                    .focusProperties {
                        next = third
                        previous = first
                    },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = secondDigit,
                onValueChange = {
                    secondDigit = it
                    if (it.length == 1) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                },
            )
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = 12.dp)
                    .focusRequester(third)
                    .focusProperties {
                        next = forth
                        previous = second
                    },
                value = thirdDigit,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    thirdDigit = it
                    if (it.length == 1) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                },
            )
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = 12.dp)
                    .focusRequester(forth)
                    .focusProperties {
                        next = btn
                        previous = third
                    },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = forthDigit,
                onValueChange = {
                    forthDigit = it
                    if (it.length == 1) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                },
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
                .focusRequester(btn)
                .focusProperties {
                    previous = forth
                },

            onClick = {
                showProgress = true

                coroutineScope.launch {

                    password = firstDigit + secondDigit + thirdDigit + forthDigit
                    val request = loginRequest.also {
                        it.password = password.filter { !it.isWhitespace() }
                    }
                    val response = viewModel.multiLogin(request)

                    when (response) {

                        is Resource.Loading -> {
                            Toast.makeText(context, "loading ...", Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Success -> {
                            if (response.data?.result == "OK") {
                                viewModel.addUser(response.data.recordResponse, password)
                                showProgress = false
                                navController.navigate(Screen.OnlineFriendsScreen.route)
                            } else {
                                showProgress = false
                                Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                            }

                        }

                        is Resource.Error -> {
                            showProgress = false
                            Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                        }

                        else -> {}
                    }
                }


            },
        ) {
                Text(stringResource(R.string.login))
        }


        if (showProgress) {
            Dialog(
                onDismissRequest = { showProgress = false },
                DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CircularProgressIndicator()
                        Text(text = "Please wait")
                    }
                }
            }
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun PreviewPasswordScreen(){
//    val navController = rememberNavController()
//    PasswordScreen(navController, loginRequest)
//}