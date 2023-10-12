package com.gatepay.signalr_sample.presentation.phonenumber_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gatepay.signalr_sample.R
import com.gatepay.signalr_sample.common.DOMAIN_NAME
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.common.navigation.NavArgJsonConverter.toJson
import com.gatepay.signalr_sample.common.navigation.Screen
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberScreen(
    navController: NavController,
    viewModel: PhoneNumberViewModel = hiltViewModel()
) {

    val charLimit = 9
    val context = LocalContext.current

    var phoneNumberText by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    fun validate(text: String) {
        isError = text.length < charLimit
    }



    Column(
        modifier =
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = phoneNumberText,
            onValueChange = {
                phoneNumberText = it
                validate(phoneNumberText)
            },
            singleLine = true,
            isError = phoneNumberText.isNotEmpty() && isError,
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Limit: ${phoneNumberText.length}/$charLimit",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
            },
            keyboardActions = KeyboardActions { validate(phoneNumberText) },
            label = { Text("Phone Number") }
        )


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp),
            onClick = {
                showProgress = true

                coroutineScope.launch {
                    val request = LoginAndRegisterRequest(
                        checkPrivateNumber = false,
                        parentId = "2",
                        domainName = DOMAIN_NAME,
                        password = "",
                        userName = phoneNumberText
                    )

                    val response = viewModel.loginAndRegister(request)

                    when (response) {

                        is Resource.Loading -> {
                            Toast.makeText(context, "loading ...", Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Success -> {
                            if (response.data?.result == "OK") {
                                val loginRequestString = request.toJson()
                                showProgress = false
                                navController.navigate(
                                    Screen.PasswordScreen.passLoginRequest(
                                        loginRequestString
                                    )
                                )
                            } else {
                                showProgress = false
                                Toast.makeText(context, response.data?.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                        is Resource.Error -> {
                            showProgress = false
                            Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
        ) {
            Text(text = stringResource(id = R.string.register))
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
                        .background(White, shape = RoundedCornerShape(8.dp))
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


@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    PhoneNumberScreen(navController)
}