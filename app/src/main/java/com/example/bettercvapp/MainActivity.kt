package com.example.bettercvapp

import CvScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.better_cv.screens.ProfileScreen
import com.example.bettercvapp.data.Country1
import com.example.bettercvapp.data.MyCV
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
                    BackHandler {
                        onBackPressedDispatcher
                    }
                    LogApplication()
                }
            }
        }
    }



    @Composable
    fun LogApplication() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "Country", builder = {

            composable("LoginScreen", content = { LoginScreen(navController = navController) })
            composable("RegisterScreen", content = { RegisterScreen(navController = navController) })
            composable("ForgotPasswordScreen", content = { ForgotPasswordScreen(navController = navController) })
            composable("AddProject", content = { AddProject(navController = navController)})
            composable("ProfessionalExpScreen", content = { ProfessionalExpScreen(navController = navController)})
            composable("Recommendation", content = { Recommendation(navController = navController)})
            composable("Formation", content = { Formation(navController = navController) })
            composable("Country", content = { Country(navController = navController) })
            composable("ProfileScreen", content = { ProfileScreen(navController = navController)})
            composable("AddressNumber", content = { AddressNumber(navController = navController)})
            composable("EditCv", content = { EditCv(navController = navController)})
            composable("HomeScreens", content = { HomeScreens(navController = navController)})
            composable("ShareCv", content = { ShareCv(navController = navController)})
            composable("ModelScreen", content = { ModelScreen(navController = navController)})
            composable("Splashscreen",){ Splashscreen(navController = navController) }
            composable("percentage",){ percentage(navController = navController) }
            composable("MyCV",){ MyCV()}
            composable("CvScreen",){ CvScreen(navController = navController)}
            composable("CvScreen2",){ CvScreen2(navController = navController)}
            composable("CvScreen3",){ CvScreen3(navController = navController)}
            composable("CvScreen4",){ CvScreen4(navController = navController)}
            composable("LettreMotivationScreen",){ LettreMotivationScreen(navController = navController)}
            composable("Competence",){ Competence(navController = navController)}
            composable("Country1",){ Country1()}
        })
    }


    @Composable
    fun BackHandler(onBackPressed: () -> Unit) {
        val backCallback = remember {
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            }
        }

        val lifecycleOwner = LocalLifecycleOwner.current
        val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

        DisposableEffect(lifecycleOwner, dispatcher) {
            dispatcher.addCallback(backCallback)
            onDispose {
                backCallback.remove()
            }
        }
    }
}

