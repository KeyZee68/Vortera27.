package com.bayxd.vortera27.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

private val DeepSlateGray = Color(0xFF1E2229)
private val Terracotta = Color(0xFFD96B43)
private val SageGreen = Color(0xFF7D9D82)

enum class NavDestination { HOME, SEARCH, FOCUS, LIBRARY }

@Composable
fun AsymmetricFloatingDock(
    currentDestination: NavDestination,
    onDestinationSelected: (NavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStart = 28.dp,
                        topEnd = 12.dp,
                        bottomStart = 14.dp,
                        bottomEnd = 28.dp
                    )
                )
                .background(DeepSlateGray.copy(alpha = 0.95f))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DockItem(
                icon = Icons.Default.Home,
                isSelected = currentDestination == NavDestination.HOME,
                activeColor = Terracotta,
                onClick = { onDestinationSelected(NavDestination.HOME) }
            )
            DockItem(
                icon = Icons.Outlined.Search,
                isSelected = currentDestination == NavDestination.SEARCH,
                activeColor = Terracotta,
                onClick = { onDestinationSelected(NavDestination.SEARCH) }
            )
            DockItem(
                icon = Icons.Default.GraphicEq,
                isSelected = currentDestination == NavDestination.FOCUS,
                activeColor = SageGreen,
                onClick = { onDestinationSelected(NavDestination.FOCUS) }
            )
            DockItem(
                icon = Icons.Default.VideoLibrary,
                isSelected = currentDestination == NavDestination.LIBRARY,
                activeColor = Terracotta,
                onClick = { onDestinationSelected(NavDestination.LIBRARY) }
            )
        }
    }
}

@Composable
private fun DockItem(
    icon: ImageVector,
    isSelected: Boolean,
    activeColor: Color,
    onClick: () -> Unit
) {
    val tintColor by animateColorAsState(
        targetValue = if (isSelected) activeColor else Color.Gray.copy(alpha = 0.6f),
        label = "DockIconTint"
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tintColor,
            modifier = Modifier.size(24.dp)
        )
    }
}
