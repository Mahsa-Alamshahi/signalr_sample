package com.gatepay.signalr_sample.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen(){

    var firstDigit by remember { mutableStateOf("") }
    var secondDigit by remember { mutableStateOf("") }
    var thirdDigit by remember { mutableStateOf("") }
    var forthDigit by remember { mutableStateOf("") }

    Column(
        modifier=
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Row(
            modifier =
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {

            TextField(
                modifier = Modifier.weight(1f)
                    .padding(
                        all =
                        12.dp
                    ),
                value = firstDigit,
                onValueChange = { firstDigit = it },
            )
            TextField(
                modifier = Modifier.weight(1f)
                    .padding(
                        all =
                        12.dp
                    ),
                value = secondDigit,
                onValueChange = { secondDigit = it },
            )
            TextField(
                modifier = Modifier.weight(1f)
                    .padding(
                        all =
                        12.dp
                    ),
                value = thirdDigit,
                onValueChange = { thirdDigit = it },
            )
            TextField(
                modifier = Modifier.weight(1f)
                    .padding(
                        all =
                        12.dp
                    ),
                value = forthDigit,
                onValueChange = { forthDigit = it },
            )
        }

        Button(onClick = {

        },
            Modifier
                .fillMaxWidth()
                .padding(
                    all =
                    12.dp
                ),) {
            Text("Login")
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun PreviewPasswordScreen(){
    PasswordScreen()
}