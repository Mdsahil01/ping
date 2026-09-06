package com.mdsahil.ping.ui.onboarding

import android.R.attr.onClick
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mdsahil.ping.data.UserPreferencesRepository
import com.mdsahil.ping.ui.components.ConversationInput
import com.mdsahil.ping.ui.components.MessageBubble
import com.mdsahil.ping.ui.components.TypingIndicator
import com.mdsahil.ping.ui.navigation.Routes
import com.mdsahil.ping.ui.theme.PingTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding

@Composable
fun OnboardingScreen(
    navController: NavController
) {

    var name = remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    var submittedName  by remember { mutableStateOf("") }
    var showTyping1 by remember { mutableStateOf(true) }
    var showMessage1 by remember { mutableStateOf(false) }
    var showTyping2 by remember { mutableStateOf(false) }
    var showMessage2 by remember { mutableStateOf(false) }
    var showInput by remember { mutableStateOf(false) }
    var showTyping3 by remember { mutableStateOf(false) }
    var showMessage3 by remember { mutableStateOf(false) }

    var showTyping4 by remember { mutableStateOf(false) }
    var showMessage4 by remember { mutableStateOf(false) }

    var showTyping5 by remember { mutableStateOf(false) }
    var showMessage5 by remember { mutableStateOf(false) }

    var showButton by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repository = UserPreferencesRepository(context)

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
    LaunchedEffect(submitted) {
        if (submitted) {
            delay(500)
            showTyping3 = true

            delay(800)
            showTyping3 = false
            showMessage3 = true

            delay(700)
            showTyping4 = true

            delay(800)
            showTyping4 = false
            showMessage4 = true

            delay(700)
            showTyping5 = true

            delay(800)
            showTyping5 = false
            showMessage5 = true

            delay(500)
            showButton = true
        }
    }


    OnboardingQuestion(
        name = name.value,
        onNameChange = {
            name.value = it
        },
        onContinue = {

            submittedName = name.value
            name.value = ""

            scope.launch {
                submitted = true
                delay(1000)
            }
        },

        onBegin = {
            scope.launch {
                repository.saveUserName(name = submittedName)
                repository.completeOnboarding()

                navController.navigate(
                    Routes.HOME.replace("{name}", submittedName)
                ) {
                    popUpTo(Routes.ONBOARDING) {
                        inclusive = true
                    }
                }
            }
        },
        submitted = submitted,
        showTyping3 = showTyping3,
        showMessage3 = showMessage3,
        showTyping4 = showTyping4,
        showMessage4 = showMessage4,
        showTyping5 = showTyping5,
        showMessage5 = showMessage5,
        showButton = showButton,
        showTyping1 = showTyping1,
        showMessage1 = showMessage1,
        showTyping2 = showTyping2,
        showMessage2 = showMessage2,
        showInput = showInput,
        submittedName = submittedName,
    )
}

@Composable
fun OnboardingQuestion(
    name: String,
    onNameChange: (String) -> Unit,
    onContinue: () -> Unit,
    onBegin: () -> Unit,
    showTyping1: Boolean,
    showMessage1: Boolean,
    showTyping2: Boolean,
    showMessage2: Boolean,
    showInput: Boolean,
    submitted: Boolean,
    submittedName : String,
    showTyping3: Boolean,
    showMessage3: Boolean,
    showTyping4: Boolean,
    showMessage4: Boolean,
    showTyping5: Boolean,
    showMessage5: Boolean,
    showButton: Boolean,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
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
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(
                top = 28.dp,
                bottom = 16.dp
            )
        ) {

            item {
                AnimatedVisibility(showTyping1) {
                    TypingIndicator()
                }
            }

            item {
                AnimatedVisibility(showMessage1) {
                    MessageBubble(
                        message = "I don't like calling people \"User.\""
                    )
                }
            }

            item {
                AnimatedVisibility(showTyping2) {
                    TypingIndicator()
                }
            }

            item {
                AnimatedVisibility(showMessage2) {
                    MessageBubble(
                        message = "What should I call you?"
                    )
                }
            }

            item {
                AnimatedVisibility(submitted) {
                    MessageBubble(
                        message = submittedName,
                        isFromUser = true
                    )
                }
            }

            item {
                AnimatedVisibility(showTyping3) {
                    TypingIndicator()
                }
            }

            item {
                AnimatedVisibility(showMessage3) {
                    MessageBubble(
                        message = "Nice to meet you, $submittedName! 👋"
                    )
                }
            }

            item {
                AnimatedVisibility(showTyping4) {
                    TypingIndicator()
                }
            }

            item {
                AnimatedVisibility(showMessage4) {
                    MessageBubble(
                        message = "I'm Ping."
                    )
                }
            }

            item {
                AnimatedVisibility(showTyping5) {
                    TypingIndicator()
                }
            }

            item {
                AnimatedVisibility(showMessage5) {
                    MessageBubble(
                        message = "I'm here whenever you want to talk, reflect, or just think out loud."
                    )
                }
            }
        }
        AnimatedVisibility(showButton) {
            Button(
                onClick = onBegin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
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

        AnimatedVisibility(
            visible = showInput && !submitted,
            modifier = Modifier.imePadding()
        ) {
            ConversationInput(
                value = name,
                onValueChange = onNameChange,
                onSend = onContinue
            )
        }


        Spacer(modifier = Modifier.height(24.dp))

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    PingTheme {
        OnboardingScreen(navController = rememberNavController())
    }
}