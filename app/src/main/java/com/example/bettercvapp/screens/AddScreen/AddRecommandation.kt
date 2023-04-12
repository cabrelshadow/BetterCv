package com.example.bettercvapp.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.Footer
import com.example.bettercvapp.Height
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.InputBoxShape
import com.example.bettercvapp.ui.theme.Poppins
import com.example.bettercvapp.ui.theme.PrimaryColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Recommendation(navController: NavController) {
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 40.dp)
        ) {
            stickyHeader {
                TopBar(navController)
                TopTitleBar()
            }
            items(1) {
                Spacer(modifier = Modifier.height(30.dp))
                EnterInfo()
                Spacer(modifier = Modifier.height(150.dp))
            }
        }
    }
    Box(
        Modifier
            .offset(0.dp,600.dp)
    ) {
        Footer("Add new Recommendation",navController,"HomeScreen")
    }

}

@Composable
private fun TopBar(navController: NavController){
    Surface{
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            TextButton(
                onClick = {navController.navigate("AddProject"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true } },
                //contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.app_name)
                )
                Text(
                    text = "back",
                    color = Color.Black,
                    fontFamily = Poppins,
                    fontSize = 15.sp,
                )
                Spacer(Modifier.weight(1f))
                //texte save
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "save Draf",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                    )
                }
            }

        }
    }
}

@Composable
private fun TopTitleBar(){
    Surface() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Recommendation",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
private fun EnterInfo (){
    val notification = remember{ mutableStateOf("") }
    if(notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value=""
    }
    var PersonName by remember { mutableStateOf("") }
    var Relationship by remember { mutableStateOf("") }
    var ResearchPost by remember{ mutableStateOf("") }
    var Message by remember{ mutableStateOf("") }
    var Number by remember{ mutableStateOf("") }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "your recommender Name",
            fontFamily = Poppins,
            fontSize =16.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = PersonName, onValueChange = { PersonName = it },
            Modifier
                .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true
        )
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Your Relation Ship",
            fontFamily = Poppins,
            fontSize =16.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = Relationship, onValueChange = { Relationship = it },
            Modifier
                .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true
        )
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Research Post",
            fontFamily = Poppins,
            fontSize =16.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = ResearchPost, onValueChange = { ResearchPost = it },
            Modifier
                .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true
        )
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Message of your recommendation",
            fontFamily = Poppins,
            fontSize =16.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = Message, onValueChange = { Message = it },
            Modifier
                .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true
        )
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Number of your Recommender",
            fontFamily = Poppins,
            fontSize =16.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = Number, onValueChange = { Number = it },
            Modifier
                .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true
        )
    }

}

