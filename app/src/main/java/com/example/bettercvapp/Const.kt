package com.example.bettercvapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bettercvapp.ui.theme.InputBoxShape

val MyShape = RoundedCornerShape(50)
val Height = 55.dp

@Composable
fun Footer(nom : String, navController: NavController, route:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 70.dp, horizontal = 32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            BlueHorizontalLine()
        }
        Button(
            onClick = { navController.navigate("$route"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true } },
            modifier = Modifier
                .offset(90.dp, 0.dp)
                //.background(MaterialTheme.colors.primary)
                .height(35.dp),
            shape = InputBoxShape.medium,
        ) {
            Text(
                text = "Save & Continue",
                color = Color.White,
            )
        }

    }
}

@Composable
fun BlueHorizontalLine() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(2.dp)
            .offset(0.dp, (-50).dp)
            .border(width = 1.dp, color = MaterialTheme.colors.primary),
        color = MaterialTheme.colors.primary
    ){
    }
}
