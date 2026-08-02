package com.mdsahil.ping.ui.splash

import android.R.attr.text
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.mdsahil.ping.R
import com.mdsahil.ping.ui.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.io.path.Path
import kotlin.io.path.moveTo

@Composable
fun SplashScreen(
    navController: NavController
){
    val scale = remember { Animatable(0.92f) }
    val alpha = remember { Animatable(0f) }
    val progress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {

        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(700)
            )
        }

        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(700)
            )
        }
        launch {
            progress.animateTo(
                targetValue = 1f,
                animationSpec = tween(1800)
            )
        }





        delay(2200)

        navController.navigate(Routes.ONBOARDING) {
            popUpTo(Routes.SPLASH) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .graphicsLayer(
                alpha = alpha.value,
                scaleX = scale.value,
                scaleY = scale.value
            ),
        contentAlignment = Alignment.Center

    ){



        Column(
            modifier = Modifier.offset(y = (-56).dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = painterResource(R.drawable.ping_logo),
                contentDescription = "Ping Logo",
                modifier = Modifier
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Every notification should feel like the start of a story.",
                color = Color(0xFFBDBDBD),
                fontSize = 15.sp,
                lineHeight = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(260.dp)
            )

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 20.dp)
                .width(80.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF2C2C2C))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress.value)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFFFC107))
            )
        }
    }
}



