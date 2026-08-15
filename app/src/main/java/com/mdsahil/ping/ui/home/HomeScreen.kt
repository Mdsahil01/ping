package com.mdsahil.ping.ui.home

  import android.R.attr.name
  import androidx.compose.foundation.Image
  import com.mdsahil.ping.R
  import androidx.compose.foundation.background
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
  import androidx.compose.foundation.rememberScrollState
  import androidx.compose.foundation.shape.CircleShape
  import androidx.compose.foundation.shape.RoundedCornerShape
  import androidx.compose.foundation.verticalScroll
  import androidx.compose.material.icons.Icons
  import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
  import androidx.compose.material.icons.filled.SentimentSatisfied
  import androidx.compose.material.icons.filled.WbSunny
  import androidx.compose.material3.Card
  import androidx.compose.material3.CardDefaults
  import androidx.compose.material3.Icon
  import androidx.compose.material3.MaterialTheme
  import androidx.compose.material3.Scaffold
  import androidx.compose.material3.Text
  import androidx.compose.runtime.Composable
  import androidx.compose.ui.Alignment
  import androidx.compose.ui.Modifier
  import androidx.compose.ui.draw.clip
  import androidx.compose.ui.graphics.Color
  import androidx.compose.ui.res.painterResource
  import androidx.compose.ui.text.font.FontWeight
  import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
  import androidx.compose.ui.unit.sp
  import com.mdsahil.ping.ui.theme.PingTextPrimary
  import com.mdsahil.ping.ui.theme.PingTextSecondary
  import com.mdsahil.ping.ui.theme.PingTheme
  import com.mdsahil.ping.ui.theme.PingYellow

 @Composable
    fun HomeScreen(
        name : String
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                HomeBottomBar()
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
                    .statusBarsPadding()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ping_icon),
                        contentDescription = "Ping",
                        modifier = Modifier.size(44.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

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

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF101012)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Small yellow Ping face
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(PingYellow),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ping_mood_icon),
                                contentDescription = "Ping",
                                modifier = Modifier.size(56.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        // Greeting
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Good morning, $name",
                                color = PingTextPrimary,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "What's on your mind today?",
                                color = PingTextSecondary,
                                fontSize = 14.sp
                            )
                        }

                        // Small sun on right
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.WbSunny,
                                contentDescription = null,
                                tint = PingYellow,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.height(18.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Continue your conversations",
                    color = PingTextSecondary,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors
                        (
                        containerColor = Color(0xFF101012),
                    ),

                    onClick = {
                        // Reflection navigation later
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(R.drawable.reflection_icon),
                            contentDescription = "Reflection",
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Reflection",
                                color = PingTextPrimary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "Understand yourself better",
                                color = PingTextSecondary,
                                fontSize = 13.sp
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = PingTextSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    onClick = {
                        // Future Self navigation later
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF101012)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(R.drawable.future_self_icon),
                            contentDescription = "Future Self",
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Future Self",
                                color = PingTextPrimary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "Talk to the version of you you're becoming",
                                color = PingTextSecondary,
                                fontSize = 13.sp
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = PingTextSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    onClick = {
                        // Random Thoughts navigation later
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF101012)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(R.drawable.random_thoughts_icon),
                            contentDescription = "Random Thoughts",
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Random Thoughts",
                                color = PingTextPrimary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "Say whatever's on your mind",
                                color = PingTextSecondary,
                                fontSize = 13.sp
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = PingTextSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

            }
        }
    }
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    PingTheme {
        HomeScreen(name = "Sahil")
    }
}