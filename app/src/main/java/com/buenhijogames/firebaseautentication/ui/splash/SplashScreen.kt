package com.buenhijogames.firebaseautentication.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.buenhijogames.firebaseautentication.FanViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToDetail: () -> Unit,
    navigateToLoginScreen: () -> Unit,
    fanViewModel: FanViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Splash Screen", color = Color.White, fontSize = 24.sp)

        LaunchedEffect(key1 = true) {
            delay(1500)
            fanViewModel.checkDestination(
                navigateToDetail = navigateToDetail,
                navigateToLogin = navigateToLoginScreen
            )
        }
    }
}
