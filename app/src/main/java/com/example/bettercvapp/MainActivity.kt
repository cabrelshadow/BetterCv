package com.example.bettercvapp

import CvScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.better_cv.screens.ProfileScreen
import com.example.better_cv.screens.UpProfileScreen
import com.example.bettercvapp.ModeleGenerer.*
import com.example.bettercvapp.screens.*
import com.example.bettercvapp.screens.AddScreen.*
import com.example.bettercvapp.screens.UpdateScreen.*
import com.example.bettercvapp.showdata.Com
import com.example.bettercvapp.ui.theme.BackgroundColor
import com.example.bettercvapp.ui.theme.BetterCvAppTheme
import com.example.expprofessionelle.ProfessionalExpScreen
import com.google.firebase.firestore.FirebaseFirestore


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

        NavHost(navController = navController, startDestination = "Splashscreen", builder = {

            composable("LoginScreen", content = { LoginScreen(navController = navController) })
            composable("RegisterScreen", content = { RegisterScreen(navController = navController) })
            composable("HomeScreens", content = { HomeScreens(navController = navController)})
            composable("MenuForm", content = { MenuForm(navController = navController)})
            composable("ForgotPasswordScreen", content = { ForgotPasswordScreen(navController = navController) })
            composable("Splashscreen",content = {Splashscreen(navController = navController) })
            composable("NewCvScreen",content = { NewCvScreen(navController = navController)})
            composable("NewCvScreen2",content = { NewCvScreen2(navController = navController)})
            composable("NewCvScreen3",content = { NewCvScreen3(navController = navController)})
            composable("NewCvScreen4",content = { NewCvScreen4(navController = navController)})
            composable("ModelScreen", content = { ModelScreen(navController = navController)})
            composable("percentage",content ={ percentage(navController = navController) })
            composable("CvScreen",content = { CvScreen(navController = navController)})
            composable("CvScreen2",content = { CvScreen2(navController = navController)})
            composable("CvScreen3", content = { CvScreen3(navController = navController)})
            composable("CvScreen4", content = { CvScreen4(navController = navController)})
            composable("LettreMotivationScreen", content = { LettreMotivationScreen(navController = navController)})

            composable("AddProject", content = { AddProject(navController = navController,this@MainActivity)})
            composable("ProfessionalExpScreen", content = { ProfessionalExpScreen(navController = navController,this@MainActivity)})
            composable("Recommendation", content = { Recommendation(navController = navController,this@MainActivity)})
            composable("Formation", content = { Formation(navController = navController,this@MainActivity) })
            composable("Country", content = { Country(navController = navController,this@MainActivity) })
            composable("ProfileScreen", content = { ProfileScreen(navController = navController,this@MainActivity)})
            composable("AddressNumber", content = { AddressNumber(navController = navController,this@MainActivity)})
            composable("Competence", content = { Competence(navController = navController,this@MainActivity)})
            composable("Hobbies", content = { Hobbies(navController = navController,this@MainActivity) })

            composable("UPMenuForm", content = { UPMenuForm(navController = navController) })

            composable("UpProfileScreen", content = { UpProfileScreen(navController = navController,this@MainActivity)})
            composable("UpRecommendation", content = { UpRecommendation(navController = navController,this@MainActivity)})
            composable("UpAddressNumber", content = { UpAddressNumber(navController = navController,this@MainActivity)})
            composable("UpCompetence", content = { UpCompetence(navController = navController,this@MainActivity) })
            composable("UpFormationScreen", content = { UpFormationScreen(navController = navController,this@MainActivity) })
            composable("UpProfessionalExpScreen", content = { UpProfessionalExpScreen(navController = navController,this@MainActivity) })
            composable("UpHobbies", content = { UpHobbies(navController = navController,this@MainActivity) })
            composable("UPCountryScreen", content = { UPCountryScreen(navController = navController,this@MainActivity) })
            composable("UpProject", content = { UpProject(navController = navController,this@MainActivity) })
            composable("NewUserModel", content = { NewUserModel(navController = navController) })

        })
    }
}


/*@Composable
fun Comp() {
    var documentCount by remember { mutableStateOf(0) }

    Column {
        FirebaseFirestore.getInstance().collection("Competence")
            .get()
            .addOnSuccessListener { documents ->
                documentCount = documents.size()
            }
    }
}*/
