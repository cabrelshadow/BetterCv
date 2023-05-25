package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun percentage(navController: NavController){

    Scaffold(bottomBar = { Bac(navController)}, content = ({ content()}))
}

@Composable
fun Bac(navController : NavController){
    Row(modifier = Modifier) {

        Button(onClick = { navController.navigate("HomeScreens"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(10.dp)
        ) {
            Text(text = "Bac to home")
        }
    }
}

@Composable
fun content(){
    val c1="#FFCFD8D0"
    Column(modifier = Modifier   .padding(start = 10.dp, end = 10.dp)){


        // Ce box represente la partie des textes
        Box(modifier = Modifier){
            Column(modifier = Modifier .padding(12.dp),
                verticalArrangement = Arrangement.Center

            ) {

                Row(modifier = Modifier .padding(start = 70.dp, end = 12.dp)) {
                    Text(text = "Your CV is checked !", fontWeight = FontWeight.Bold,)
                }

                Row(modifier = Modifier .padding(start = 30 .dp, end = 12.dp)) {
                    Text(text = "The following data shows  how your cv mathes the job you are applying for !"
                        , modifier = Modifier , Color.Gray
                    )
                }

            }
        }
        // ce box presentera le pourcentage generale

        Row(modifier = Modifier

            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Blue),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically



        ){
            Column(modifier = Modifier ) {
                Row(modifier = Modifier) {

                    Text(text = "90%" , modifier=Modifier, Color.White, fontSize = 80.sp)
                }
                Row(modifier = Modifier){
                    Text(text = "Compatibility score", modifier = Modifier, Color.White, fontSize = 20.sp)

                }
            }

        }

    }

    // ce box est pour le skill

    Column(modifier = Modifier
        .padding(top = 250.dp)
    ) {
        Box(modifier = Modifier .padding(bottom = 25.dp)){
            Column(modifier = Modifier) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp, start = 4.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column() {
                        Text(text = "Competence")
                    }

                    Column() {
                        Text(text = "90/100")
                    }

                }

                // bar de progression
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    //.background(Color.Gray)
                    .shadow(2.dp, ambientColor = Color.Black, shape = RoundedCornerShape(12.dp))
                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Green)
                    ){}
                }
            }
        }
        Box(modifier = Modifier .padding(bottom = 25.dp)){
            Column(modifier = Modifier) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp, start = 4.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column() {
                        Text(text = "Experience")
                    }

                    Column() {
                        Text(text = "90/100")
                    }

                }

                // bar de progression
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    //.background(Color.Gray)
                    .shadow(2.dp, ambientColor = Color.Black, shape = RoundedCornerShape(12.dp))
                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Green)
                    ){}
                }
            }
        }
        Box(modifier = Modifier .padding(bottom = 25.dp)){
            Column(modifier = Modifier) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp, start = 4.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column() {
                        Text(text = "skill")
                    }

                    Column() {
                        Text(text = "90/100")
                    }

                }

                // bar de progression
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    //.background(Color.Gray)
                    .shadow(2.dp, ambientColor = Color.Black, shape = RoundedCornerShape(12.dp))
                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Green)
                    ){}
                }
            }
        }
        Box(modifier = Modifier .padding(bottom = 25.dp)){
            Column(modifier = Modifier) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp, start = 4.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column() {
                        Text(text = "Education")
                    }

                    Column() {
                        Text(text = "90/100")
                    }

                }

                // bar de progression
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    //.background(Color.Gray)
                    .shadow(2.dp, ambientColor = Color.Black, shape = RoundedCornerShape(12.dp))
                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Green)
                    ){}
                }
            }
        }

    }
}
