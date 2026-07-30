package com.mdsahil.ping.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.mdsahil.ping.ui.components.ConversationInput
import com.mdsahil.ping.ui.components.MessageBubble
import com.mdsahil.ping.ui.components.TypingIndicator


@Composable
fun OnboardingScreen() {

    var name = remember { mutableStateOf("") }
    var showWelcome by remember { mutableStateOf(false) }

    if (!showWelcome) {

        OnboardingQuestion(
            name = name.value,
            onNameChange = {
                name.value = it
            },
            onContinue = {
                showWelcome = true
            }
        )

    } else {

        WelcomeMessage(
            name = name.value
        )

    }
}


@Composable
fun OnboardingQuestion(
    name: String,
    onNameChange: (String) -> Unit,
    onContinue: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){

        TypingIndicator()

        Spacer(modifier = Modifier.height(24.dp))

        MessageBubble(
            message = "I don't like calling people \"User.\""
        )

        Spacer(modifier = Modifier.height(8.dp))

        MessageBubble(
            message = "What should I call you?"
        )

        Spacer(modifier = Modifier.height(32.dp))

        ConversationInput(
            value = name,
            onValueChange = onNameChange,
            onSend = onContinue
        )

        Spacer(modifier = Modifier.height(24.dp))

    }
}



@Composable
fun WelcomeMessage(
    name: String
) {
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
            text = name
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}