package com.gatepay.signalr_sample.presentation

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
fun LoginScreen(){

    var text by remember { mutableStateOf("Hello") }

    Column(modifier=
        Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth().padding(all =
            12.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Phone Number") }
        )
        Button(onClick = { }, Modifier.fillMaxWidth().padding(all =
        12.dp),) {
            Text("Register")
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen(){
LoginScreen()
}