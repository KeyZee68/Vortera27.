package com.bayxd.vortera27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.bayxd.vortera27.presentation.components.AsymmetricFloatingDock
import com.bayxd.vortera27.presentation.components.NavDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentNav by remember { mutableStateOf(NavDestination.HOME) }

            Scaffold(
                containerColor = Color(0xFF1A1A1A),
                bottomBar = {
                    AsymmetricFloatingDock(
                        currentDestination = currentNav,
                        onDestinationSelected = { currentNav = it }
                    )
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    when (currentNav) {
                        NavDestination.HOME -> VorteraHomeHeader()
                        NavDestination.SEARCH -> {}
                        NavDestination.FOCUS -> {}
                        NavDestination.LIBRARY -> {}
                    }
                }
            }
        }
    }
}

@Composable
fun VorteraHomeHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "Vortera27",
            fontFamily = FontFamily.Serif,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD96B43),
            letterSpacing = (-0.5).sp
        )
        Text(
            text = "by BayXD",
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7D9D82).copy(alpha = 0.35f),
            modifier = Modifier
                .align(Alignment.Start)
                .offset(x = 64.dp, y = (-6).dp)
        )
    }
}
