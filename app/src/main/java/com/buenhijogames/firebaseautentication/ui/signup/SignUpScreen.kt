package com.buenhijogames.firebaseautentication.ui.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buenhijogames.firebaseautentication.FanViewModel
import com.buenhijogames.firebaseautentication.ui.theme.PurpleGrey40
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SignUpScreen(
    fanViewModel: FanViewModel,
    navigateToDetail: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x4C2B98FF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .padding(horizontal = 32.dp)
                .height(200.dp)
                .width(300.dp)
                .background(color = Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text("Logo Registro", color = Color.White, fontSize = 24.sp)
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            OutlinedTextField(
                value = fanViewModel.email,
                onValueChange = { fanViewModel.email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 16.dp)
            )

            OutlinedTextField(
                value = fanViewModel.password,
                onValueChange = { fanViewModel.password = it },
                label = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(top = 16.dp)
            )

            if (fanViewModel.isLoading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 32.dp),
                    color = Color.Gray
                )
            }

            if (fanViewModel.emailExiste) {
                Text(
                    "Ese email ya está registrado.\nPor favor, inicia sesión",
                    color = Color.Red,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }

        OutlinedButton(
            onClick = {
                if (fanViewModel.email.isNotEmpty() && fanViewModel.password.isNotEmpty()) {
                    fanViewModel.register(fanViewModel.email, fanViewModel.password, navigateToDetail)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 16.dp)
                .padding(bottom = 32.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFF261A41),
                containerColor = PurpleGrey40
            )
        ) {
            Text("Registrarse", color = Color.White)
        }
    }
}
