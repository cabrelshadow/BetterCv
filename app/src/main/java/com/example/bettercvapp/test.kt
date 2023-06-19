package com.example.bettercvapp


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun FirstComposable(onButtonClick: () -> Unit) {
    Button(onClick ={onButtonClick} ) {
        Text("Cliquez ici")
    }
}
@Composable
fun FirstComposables(onButtonClick: () -> Unit) {
    Button(onClick ={onButtonClick} ) {
        Text("Cliquez ici2")
    }
}


@Composable
fun SecondComposable(booleanValue: Boolean) {
    if (booleanValue) {
        Text("La valeur booléenne est vraie")
    } else {
        Text("La valeur booléenne est fausse")
    }
}

@Composable
fun MyScreen() {
    var booleanValue by remember { mutableStateOf(false) }

    Column {
        FirstComposable {
            booleanValue = true
        }
        FirstComposables {
            booleanValue = false
        }
        SecondComposable(booleanValue)
    }
}
