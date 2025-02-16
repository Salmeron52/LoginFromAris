package com.buenhijogames.firebaseautentication

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.buenhijogames.firebaseautentication.data.AuthService
import com.buenhijogames.firebaseautentication.navigation.Error
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FanViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    private var _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun login(email: String, password: String, navigateToDetail: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = withContext(Dispatchers.IO) {
                    authService.login(email, password)
                }
                if (result != null) {
                    navigateToDetail()
                } else {
                    Log.e("FanViewModel", "Error logging in: $result")
                }
            } catch (e: Exception) {
                Log.e("FanViewModel", "Error logging in: $e")
            }
            _isLoading.value = false
        }
    }
}