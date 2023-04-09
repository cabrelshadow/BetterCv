package com.example.bettercvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.better_cv.screens.ProfileScreen
import com.example.bettercvapp.screens.*
import com.example.bettercvapp.screens.AddScreen.Formation
import com.example.bettercvapp.ui.theme.BackgroundColor
import com.example.bettercvapp.ui.theme.BetterCvAppTheme
import com.example.expprofessionelle.ProfessionalExpScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterCvAppTheme {
                // A surface container using the 'background' color from the theme
                Surface( color= BackgroundColor,
                    modifier = Modifier.fillMaxSize(),

                ) {
                    LogApplication()
                    //LoginScreen()
                    //RegisterScreen()

                }
            }
        }
    }

    @Composable
    fun LogApplication() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "LoginScreen", builder = {
            composable("LoginScreen", content = { LoginScreen(navController = navController) })
            composable("RegisterScreen", content = { RegisterScreen(navController = navController) })
            composable("HomeScreen", content = { HomeScreen(navController = navController) })
            composable("ForgotPasswordScreen", content = { ForgotPasswordScreen(navController = navController) })
            composable("AddProject", content = { AddProject(navController = navController)})
            composable("ProfessionalExpScreen", content = { ProfessionalExpScreen(navController = navController)})
            composable("Recommendation", content = { Recommendation(navController = navController)})
            composable("Formation", content = { Formation(navController = navController) })
            composable("Country", content = { Country(navController = navController)})
            composable("ProfileScreen", content = { ProfileScreen(navController = navController)})
            composable("AddressNumber", content = { AddressNumber(navController = navController)})
        })
    }
}
