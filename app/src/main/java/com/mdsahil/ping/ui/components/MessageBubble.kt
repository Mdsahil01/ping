package com.mdsahil.ping.ui.components

import android.R.id.message
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageBubble(
    message: String,
    isFromUser: Boolean = false
){

    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Text(
            text = message,
            modifier = Modifier.padding(16.dp)
        )

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MessageBubblePreview() {
    MessageBubble(
        message = "I don't like calling people \"User.\""
    )
}