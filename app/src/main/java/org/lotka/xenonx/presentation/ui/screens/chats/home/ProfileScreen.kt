package org.lotka.xenonx.presentation.ui.screens.chats.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onToggleTheme: () -> Unit,
    isDarkTheme: Boolean,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationItemMenu(
                selectItem = BottomNavigationItem.PROFILE,
                navController = navController
            )
        },
        topBar = {
//            HomeTopBar(
//                onClick = {},
//                mainScreens = true,
//                onToggleTheme = {
//                    onToggleTheme()
//                },
//                onBackPressed = onBack,
//                isDarkMode = isDarkTheme,
//            )
        }, drawerElevation = 0.dp,
        drawerGesturesEnabled = false,
        drawerContentColor = Color.White,
        drawerScrimColor = Color.White,


        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

            }
        })
        }

