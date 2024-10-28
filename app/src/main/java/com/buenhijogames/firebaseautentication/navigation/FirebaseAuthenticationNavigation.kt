package com.buenhijogames.firebaseautentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.buenhijogames.firebaseautentication.FanViewModel
import com.buenhijogames.firebaseautentication.ui.detail.DetailScreen
import com.buenhijogames.firebaseautentication.ui.error.ErrorScreen
import com.buenhijogames.firebaseautentication.ui.login.LoginScreen
import com.buenhijogames.firebaseautentication.ui.signup.SignUpScreen
import com.buenhijogames.firebaseautentication.ui.splash.SplashScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun FirebaseAuthenticationNavigation(fanViewModel: FanViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            /*SplashScreen { navController.navigate(Login) }*/
            SplashScreen (
                navigateToLoginScreen = { navController.navigate(Login) }
            )
        }
        composable<Login> {
            LoginScreen(
                navigateToSignUp = { navController.navigate(SignUp) },
                navigateToDetail = { navController.navigate(Detail) },
                navigateToError = { navController.navigate(Error) },
                fanViewModel = fanViewModel
            )
        }
        composable<SignUp> {
            SignUpScreen()
        }
        composable<Detail> {
            DetailScreen()
        }

        composable<Error> {
            ErrorScreen(
                navigateToLoginScreen = { navController.navigate(Login) }
            )
        }
    }
}