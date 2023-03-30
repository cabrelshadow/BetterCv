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
import com.example.bettercvapp.screens.LoginScreen
import com.example.bettercvapp.screens.RegisterScreen
import com.example.bettercvapp.ui.theme.BackgroundColor
import com.example.bettercvapp.ui.theme.BetterCvAppTheme

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
        })
    }
}
