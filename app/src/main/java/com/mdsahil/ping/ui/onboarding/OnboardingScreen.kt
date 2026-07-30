package com.mdsahil.ping.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay



@Composable
fun OnboardingScreen() {

    var name = remember { mutableStateOf("") }
    var showWelcome by remember { mutableStateOf(false) }
    var showTyping1 by remember { mutableStateOf(true) }
    var showMessage1 by remember { mutableStateOf(false) }
    var showTyping2 by remember { mutableStateOf(false) }
    var showMessage2 by remember { mutableStateOf(false) }
    var showInput by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {

        delay(1200)
        showTyping1 = false
        showMessage1 = true

        delay(800)
        showTyping2 = true

        delay(1200)
        showTyping2 = false
        showMessage2 = true

        delay(400)
        showInput = true
    }

    if (!showWelcome) {

        OnboardingQuestion(
            name = name.value,
            onNameChange = {
                name.value = it
            },
            onContinue = {
                showWelcome = true
            },
            showTyping1 = showTyping1,
            showMessage1 = showMessage1,
            showTyping2 = showTyping2,
            showMessage2 = showMessage2,
            showInput = showInput
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
    onContinue: () -> Unit,
    showTyping1: Boolean,
    showMessage1: Boolean,
    showTyping2: Boolean,
    showMessage2: Boolean,
    showInput: Boolean
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){

        AnimatedVisibility(showTyping1) {
            TypingIndicator()
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedVisibility(showMessage1) {
            MessageBubble(
                message = "I don't like calling people \"User.\"",
                isFromUser = false
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        AnimatedVisibility(showTyping2) {
            TypingIndicator()
        }

        AnimatedVisibility(showMessage2) {
            MessageBubble(
                message = "What should I call you?",
                isFromUser = false
            )
        }
        Spacer(modifier = Modifier.height(32.dp))


        AnimatedVisibility(showInput) {
            ConversationInput(
                value = name,
                onValueChange = onNameChange,
                onSend = onContinue
            )
        }

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