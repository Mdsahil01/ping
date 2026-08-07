package com.mdsahil.ping.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
import com.mdsahil.ping.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdsahil.ping.ui.components.ConversationInput
import com.mdsahil.ping.ui.components.MessageBubble
import com.mdsahil.ping.ui.components.TypingIndicator
import com.mdsahil.ping.ui.theme.PingTheme
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

        delay(900)
        showTyping1 = false
        showMessage1 = true

        delay(600)
        showTyping2 = true

        delay(900)
        showTyping2 = false
        showMessage2 = true

        delay(250)
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
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
            .padding(top = 12.dp),
    ){
        Row(
            modifier = Modifier.padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.ping_icon),
                contentDescription = "Ping",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = "Ping",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Your AI companion",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        AnimatedVisibility(showTyping1) {
            TypingIndicator()
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedVisibility(showMessage1 || showMessage2) {

            Column {

                Text(
                    text = "Ping",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 12.dp, bottom = 6.dp)
                )

                if (showMessage1) {
                    MessageBubble(
                        message = "I don't like calling people \"User.\""
                    )
                }

                if (showTyping2) {
                    Spacer(modifier = Modifier.height(8.dp))

                    TypingIndicator()
                }

                if (showMessage2) {
                    Spacer(modifier = Modifier.height(8.dp))

                    MessageBubble(
                        message = "What should I call you?"
                    )
                }
            }
        }

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
    var showTyping1 by remember { mutableStateOf(true) }
    var showMessage1 by remember { mutableStateOf(false) }

    var showTyping2 by remember { mutableStateOf(false) }
    var showMessage2 by remember { mutableStateOf(false) }

    var showTyping3 by remember { mutableStateOf(false) }
    var showMessage3 by remember { mutableStateOf(false) }

    var showButton by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {

        delay(800)
        showTyping1 = false
        showMessage1 = true

        delay(700)
        showTyping2 = true

        delay(800)
        showTyping2 = false
        showMessage2 = true

        delay(700)
        showTyping3 = true

        delay(800)
        showTyping3 = false
        showMessage3 = true

        delay(500)
        showButton = true
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
        ) {

            Row(
                modifier = Modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ping_icon),
                    contentDescription = "Ping Icon",
                    modifier = Modifier.size(56.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        text = "Ping",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Your AI companion",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                }
            }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Ping",
                        color = Color(0xFFFFC107),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 12.dp, bottom = 6.dp)
                    )

            AnimatedVisibility(showTyping1) {
                TypingIndicator()
            }

            AnimatedVisibility(showMessage1) {
                MessageBubble(
                    message = "Nice to meet you, $name! 👋"
                )
            }

                    Spacer(modifier = Modifier.height(4.dp))

            AnimatedVisibility(showTyping2) {
                TypingIndicator()
            }

            AnimatedVisibility(showMessage2) {

                MessageBubble(
                    message = "I'm Ping."
                )
            }

                    Spacer(modifier = Modifier.height(4.dp))

            AnimatedVisibility(showTyping3) {
                TypingIndicator()
            }

            AnimatedVisibility(showMessage3) {

                MessageBubble(
                    message = "I'm here whenever you wantto talk,\n" +
                            "reflect, or just think out loud."
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            AnimatedVisibility(visible =  showButton) {

                Button(
                    onClick = {
                        // Navigation later
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .navigationBarsPadding()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Let's Begin",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    PingTheme {
        OnboardingScreen()
    }
}