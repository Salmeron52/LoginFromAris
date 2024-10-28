package com.buenhijogames.firebaseautentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import com.buenhijogames.firebaseautentication.navigation.FirebaseAuthenticationNavigation
import com.buenhijogames.firebaseautentication.ui.theme.FirebaseAutenticationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fanViewModel: FanViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseAutenticationTheme {
                FirebaseAuthenticationNavigation(fanViewModel)
            }
        }
    }
}

