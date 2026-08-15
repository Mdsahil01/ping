package com.mdsahil.ping.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdsahil.ping.ui.theme.PingTextSecondary
import com.mdsahil.ping.ui.theme.PingTheme
import com.mdsahil.ping.ui.theme.PingYellow

@Composable
fun HomeBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = PingYellow,
                modifier = Modifier.size(28.dp)
            )

            Text(
                text = "Home",
                color = PingYellow,
                fontSize = 12.sp
            )
        }
        FloatingActionButton(
            onClick = {
                // Main action later
            },
            containerColor = PingYellow,
            contentColor = Color.Black,
            shape = CircleShape,
            modifier = Modifier
                .size(56.dp)
                .offset(y = (-8).dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "New conversation",
                modifier = Modifier.size(35.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profile",
                tint = PingTextSecondary
            )

            Text(
                text = "Profile",
                color = PingTextSecondary,
                fontSize = 12.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeBottomBarPreview(){

        HomeBottomBar()

}