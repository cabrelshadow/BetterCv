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
import com.example.bettercvapp.screens.AddScreen.*
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
                }
            }
        }
    }
    @Composable
    fun LogApplication() {
        val navController = rememberNavController()

<<<<<<< HEAD
        NavHost(navController = navController, startDestination = "Recommendation", builder = {
=======
<<<<<<< HEAD
        NavHost(navController = navController, startDestination = "ShareCv", builder = {
=======
<<<<<<< HEAD
        NavHost(navController = navController, startDestination = "EditCv", builder = {
=======
        NavHost(navController = navController, startDestination = "Recommendation", builder = {
>>>>>>> 4e3a5417f47f68452e9de19d070ea9111e59f739
>>>>>>> 6fa811a2343e8acfcba8dd56ab5a1192f72c362f
>>>>>>> f9d529343ae2498513d15fb81a00ea737bf7481b
            composable("LoginScreen", content = { LoginScreen(navController = navController) })
            composable("RegisterScreen", content = { RegisterScreen(navController = navController) })
            composable("ForgotPasswordScreen", content = { ForgotPasswordScreen(navController = navController) })
            composable("AddProject", content = { AddProject(navController = navController)})
            composable("ProfessionalExpScreen", content = { ProfessionalExpScreen(navController = navController)})
            composable("Recommendation", content = { Recommendation(navController = navController)})
            composable("Formation", content = { Formation(navController = navController) })
            composable("Country", content = { Country(navController = navController)})
            composable("ProfileScreen", content = { ProfileScreen(navController = navController)})
            composable("AddressNumber", content = { AddressNumber(navController = navController)})
            composable("EditCv", content = { EditCv(navController = navController)})
            composable("HomeScreens", content = { HomeScreens(navController = navController)})
            composable("ShareCv", content = { ShareCv(navController = navController)})
            composable("ModelScreen", content = { ModelScreen(navController = navController)})
            composable("Splashscreen",){ Splashscreen(navController = navController) }
        })
    }
}


