package com.buenhijogames.firebaseautentication.ui.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.buenhijogames.firebaseautentication.FanViewModel
import com.buenhijogames.firebaseautentication.navigation.Detail
import com.buenhijogames.firebaseautentication.ui.theme.PurpleGrey40
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun LoginScreen(
    navigateToSignUp: () -> Unit,
    navigateToDetail: () -> Unit,
    fanViewModel: FanViewModel
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x4C2B98FF)),
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
            Text("Logo Login", color = Color.White, fontSize = 24.sp)
        }
        Column(modifier = Modifier.weight(1f).verticalScroll(scrollState))
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

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp)
                    .padding(top = 8.dp)
            ) {
                Text(
                    "Regístrate",
                    fontSize = 14.sp,
                    color = PurpleGrey40,
                    modifier = Modifier.clickable { navigateToSignUp() }
                )
            }

            if (fanViewModel.isLoading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 32.dp),
                    color = Color.Gray
                )
            }
        }

        OutlinedButton(
            onClick = {
                if (fanViewModel.email.isEmpty() || fanViewModel.password.isEmpty()) {
                    Log.e("LoginScreen", "Email or password is empty")
                    return@OutlinedButton
                }
                fanViewModel.login(fanViewModel.email, fanViewModel.password, navigateToDetail)
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
            Text("Iniciar sesión", color = Color.White)
        }
    }
}