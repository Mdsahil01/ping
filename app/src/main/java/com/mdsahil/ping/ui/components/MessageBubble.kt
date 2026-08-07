package com.mdsahil.ping.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageBubble(
    message: String,
    isFromUser: Boolean = false
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = if (isFromUser)
            Alignment.End
        else
            Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Box(
            modifier = Modifier
                .widthIn(max = 340.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(
                    if (isFromUser)
                        Color(0xFFFFC107)
                    else
                        Color(0xFF323232)
                )
        ) {

            Text(
                text = message,
                color = if (isFromUser)
                    Color.Black
                else
                    Color.White,
                fontSize = 17.sp,
                lineHeight = 26.sp,
                modifier = Modifier.padding(
                    horizontal = 22.dp,
                    vertical = 16.dp
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun MessageBubblePreview() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        MessageBubble(
            message = "I don't like calling people \"User.\""
        )

        MessageBubble(
            message = "Nice to meet you, Sahil.",
            isFromUser = false
        )

        MessageBubble(
            message = "Sahil",
            isFromUser = true
        )
    }
}