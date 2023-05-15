package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Country(navController: NavController){

    //variable pour stocker les données
    var country by remember{ mutableStateOf("") }
    var city by remember{ mutableStateOf("") }
    var language by remember{ mutableStateOf("") }
    var level by remember{ mutableStateOf("") }


    //variacle de manipulation de fire store
    val db = Firebase.firestore
    val count = db.collection("Country")

    //Fonction de sauvegade de donné dans la base de données
    fun saveCountry(){
        val newCountry = hashMapOf(
            "country" to country,
            "city" to city,
            "language" to language,
            "level" to level
        )
        count.add(newCountry)
    }

    //Partie pour entrer les données (champ de texte)
    Box(
        Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 40.dp)
        ){
            stickyHeader {
                    Header(navController)
            }
            items(1) {
                //Champ a remplir numero 1
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    Modifier
                        .padding(horizontal = 18.dp)
                ) {
                    TextField(
                        value = country,
                        onValueChange = { country = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),

                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = PlaceholderColor,
                            cursorColor = PrimaryColor,
                            //focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = InputBoxShape.medium,
                        singleLine = true,
                        leadingIcon = {
                            Row(
                                modifier = Modifier.padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_count),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(BackgroundColor)
                                )
                            }
                        },

                        placeholder = {
                            Text(
                                text = "Enter the name of your country",
                                color = Color.Black
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins
                        )
                    )
                }
                //Champ a remplir numero 2
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    Modifier
                        .padding(horizontal = 18.dp)
                ) {
                    TextField(
                        value = country, onValueChange = { country = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = PlaceholderColor,
                            cursorColor = PrimaryColor,
                            //focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = InputBoxShape.medium,
                        singleLine = true,
                        leadingIcon = {
                            Row(
                                modifier = Modifier.padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_count),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(BackgroundColor)
                                )
                            }
                        },
                        placeholder = {
                            Text(
                                text = "Enter the name of your country",
                                color = Color.Black
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins
                        )
                    )
                }

                //Champ a remplir numero 3
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    Modifier
                        .padding(horizontal = 18.dp)
                ) {
                    TextField(
                        value = country, onValueChange = { country = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = PlaceholderColor,
                            cursorColor = PrimaryColor,
                            //focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = InputBoxShape.medium,
                        singleLine = true,
                        leadingIcon = {
                            Row(
                                modifier = Modifier.padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_count),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(BackgroundColor)
                                )
                            }
                        },
                        placeholder = {
                            Text(
                                text = "Enter the name of your country",
                                color = Color.Black
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins
                        )
                    )
                }

                //Champ a remplir numero 4
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    Modifier
                        .padding(horizontal = 18.dp)
                ) {
                    TextField(
                        value = country, onValueChange = { country = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = PlaceholderColor,
                            cursorColor = PrimaryColor,
                            //focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = InputBoxShape.medium,
                        singleLine = true,
                        leadingIcon = {
                            Row(
                                modifier = Modifier.padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_count),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(24.dp)
                                        .background(BackgroundColor)
                                )
                            }
                        },
                        placeholder = {
                            Text(
                                text = "Enter the name of your country",
                                color = Color.Black
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins
                        )
                    )
                }
                Spacer(modifier = Modifier.height(150.dp))
            }
        }
    }
    Box(
        modifier = Modifier
            .offset(0.dp,600.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 70.dp, horizontal = 32.dp)
        ) {
            val showDialog = remember { mutableStateOf(false) }
            val sucess = remember { mutableStateOf(false) }
            Button(
                onClick = {
                    if (country.isEmpty() || city.isEmpty() || language.isEmpty() || level.isEmpty()) {
                    } else {
                    }
                },
                modifier = Modifier
                    .offset((200).dp, (38).dp)
                    .height(34.dp),
                shape = InputBoxShape.medium,
            ) {
                Text(
                    text = "Add",
                    color = Color.White,
                )
            }

            Button(
                onClick = {
                    if (country.isEmpty() || city.isEmpty() || language.isEmpty() || level.isEmpty()) {
                        showDialog.value = true
                    } else {
                        saveCountry()
                        sucess.value = true
                    }

                },
                modifier = Modifier
                    .offset(90.dp, 0.dp)
                    .height(35.dp),
                shape = InputBoxShape.medium,
            ) {
                Text(
                    text = "Save",
                    color = Color.White,
                )
            }
            /////
            if (sucess.value) {
                AlertDialog(
                    onDismissRequest = { showDialog.value = false },
                    title = { Text(text = "Information") },
                    text = { Text(text = "enregistrer avec succes") },
                    confirmButton = {
                        Button(
                            onClick = {
                                navController.navigate("AddressNumber") {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                        ) {
                            Text(text = "OK")
                        }
                    }
                )
            }

            if (showDialog.value) {
                AlertDialog(
                    onDismissRequest = { showDialog.value = false },
                    title = { Text(text = "Information") },
                    text = { Text(text = "veuillez remplir tout les champs") },
                    confirmButton = {
                        Button(
                            onClick = { showDialog.value = false },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                        ) {
                            Text(text = "OK")
                        }
                    }
                )
            }
            /////////////////
        }
    }
}

@Composable
private fun Header(navController: NavController){
    Surface(
        Modifier
            .height(200.dp)
            .clip(
                shape = RoundedCornerShape(
                    bottomEnd = 35.dp,
                    bottomStart = 35.dp
                )
            )
    ) {
        Column(
            Modifier
                .background(head),
        ) {
            TextButton(
                onClick = {navController.navigate("ProfileScreen"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true }},
                //contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.app_name),
                    Modifier.size(30.dp),
                    tint = Color.White
                )
                //Spacer(Modifier.weight(1f))
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Country and Language",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }

        }
    }
}

