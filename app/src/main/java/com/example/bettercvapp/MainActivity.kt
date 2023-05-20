package com.example.bettercvapp

import CvScreen
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
import com.example.bettercvapp.ModeleGenerer.NewCvScreen
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
        NavHost(navController = navController, startDestination = "NewCvScreen", builder = {

            composable("LoginScreen", content = { LoginScreen(navController = navController) })
            composable("RegisterScreen", content = { RegisterScreen(navController = navController) })
            composable("ForgotPasswordScreen", content = { ForgotPasswordScreen(navController = navController) })
            composable("AddProject", content = { AddProject(navController = navController,this@MainActivity)})
            composable("ProfessionalExpScreen", content = { ProfessionalExpScreen(navController = navController,this@MainActivity)})
            composable("Recommendation", content = { Recommendation(navController = navController)})
            composable("Formation", content = { Formation(navController = navController,this@MainActivity) })
            composable("Country", content = { Country(navController = navController) })
            composable("ProfileScreen", content = { ProfileScreen(navController = navController,this@MainActivity)})
            composable("AddressNumber", content = { AddressNumber(navController = navController)})
            composable("EditCv", content = { EditCv(navController = navController)})
            composable("HomeScreens", content = { HomeScreens(navController = navController)})
            composable("ShareCv", content = { ShareCv(navController = navController)})
            composable("MenuForm", content = { MenuForm(navController = navController)})
            composable("ModelScreen", content = { ModelScreen(navController = navController)})
            composable("Splashscreen",content = {Splashscreen(navController = navController) })
            composable("percentage",content ={ percentage(navController = navController) })
            composable("CvScreen",content = { CvScreen(navController = navController)})
            composable("NewCvScreen",content = { NewCvScreen(navController = navController)})
            composable("CvScreen2",content = { CvScreen2(navController = navController)})
            composable("CvScreen3", content = { CvScreen3(navController = navController)})
            composable("CvScreen4", content = { CvScreen4(navController = navController)})
            composable("LettreMotivationScreen", content = { LettreMotivationScreen(navController = navController)})
            composable("Competence", content = { Competence(navController = navController)})
        })
    }
}

