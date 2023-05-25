package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import kotlinx.coroutines.delay




@Composable
fun Splashscreen(navController: NavController){
    LaunchedEffect(key1 = true ){
        delay(5000L)
        navController.navigate("LoginScreen")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.better),
            "",
            modifier = Modifier.width(1000.dp)
        )
        CircularProgressIndicator()
    }

}