package com.mdsahil.ping.ui.onboarding

import android.R.attr.name
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun OnboardingScreen() {

    var name = remember { mutableStateOf("") }
    var showWelcome by remember {
        mutableStateOf(false)
    }

    if (!showWelcome) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Typing..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "I don't like calling people \"User.\""
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "What should I call you?"
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                label = {
                    Text("Your name")
                }
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    showWelcome = true
                },
                enabled = name.value.isNotBlank()
            ) {
                Text("Continue")
            }
        }

    } else {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Typing..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Nice to meet you,"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = name.value
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}