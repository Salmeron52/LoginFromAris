package com.buenhijogames.firebaseautentication.ui.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(navigateToLoginScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Error Screen\n\nError en la autenticación\n\nEmail o password incorrectos")

        Button(onClick = { navigateToLoginScreen() }) {
            Text("Volver a intentar")
        }
    }
}