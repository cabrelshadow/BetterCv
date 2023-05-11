package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingButton(onClick: () -> Unit, isLoading: Boolean) {
    var buttonState by remember { mutableStateOf(ButtonState.IDLE) }

    Button(
        onClick = onClick,
        enabled = !isLoading && buttonState != ButtonState.LOADING,
        elevation = ButtonDefaults.elevation(defaultElevation = 8.dp, pressedElevation = 16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        when (buttonState) {
            ButtonState.IDLE -> Text("Charger")
            ButtonState.LOADING -> CircularProgressIndicator(modifier = Modifier.size(20.dp))
            ButtonState.SUCCESS -> Text("Terminé!")
            ButtonState.ERROR -> Text("Erreur!")
        }
    }

    LaunchedEffect(isLoading) {
        buttonState = if (isLoading) ButtonState.LOADING else ButtonState.IDLE
    }
}

enum class ButtonState {
    IDLE,
    LOADING,
    SUCCESS,
    ERROR
}