package com.mdsahil.ping.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color


@Composable
    fun ConversationInput(
        value: String,
        onValueChange: (String) -> Unit,
        onSend: () -> Unit
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(),

        ) {

            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = CircleShape,
                placeholder = {
                    Text("Reply...")
                },
                singleLine = true
            )
            IconButton(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(
                            if (value.isNotBlank())
                                Color(0xFFFFC107)
                            else
                                Color(0xFF3A3A3A)
                        ),
            onClick = onSend,
            enabled = value.isNotBlank()
            ) {
            Text(
                text = "➜",
                color = if (value.isNotBlank()) Color.Black else Color.Gray
            )
        }
        }
    }
