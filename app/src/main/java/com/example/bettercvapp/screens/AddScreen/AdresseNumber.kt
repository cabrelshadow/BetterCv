package com.example.bettercvapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.BlueHorizontalLine
import com.example.bettercvapp.Footer
import com.example.bettercvapp.Height
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.InputBoxShape
import com.example.bettercvapp.ui.theme.Poppins
import com.example.bettercvapp.ui.theme.PrimaryColor
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddressNumber(navController: NavController){
    var Phone by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var urlFacebook by remember { mutableStateOf("") }
    var urlTelegram by remember { mutableStateOf("") }
    var urlInstagram by remember { mutableStateOf("") }

    val db = Firebase.firestore
    val adress = db.collection("Adress")

    fun saveAdressUser(){
        val newAdress = hashMapOf(
            "Phone" to Phone,
            "Email" to Email,
            "urlFacebook" to urlFacebook,
            "urlTelegram" to urlTelegram,
            "urlInstagram" to urlInstagram
        )
        adress.add(newAdress)
    }
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
                //EnterInfo()



                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = "your Phone Number",
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
                            value = Phone, onValueChange = { Phone = it },
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
                            text = "your Email",
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
                            value = Email, onValueChange = { Email = it },
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
                            text = "your Url Facebook",
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
                            value = urlFacebook, onValueChange = { urlFacebook = it },
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
                            text = "your Url Telegram",
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
                            value = urlTelegram, onValueChange = { urlTelegram = it },
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
                            text = "your Url Instagram",
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
                            value = urlInstagram, onValueChange = { urlInstagram = it },
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

                Spacer(modifier = Modifier.height(150.dp))
            }
        }
    }
    Box(
        Modifier
            .offset(0.dp,600.dp)
    ) {
        //Footer("   Add new Information",navController,"Formation")

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
                    onClick = { navController.navigate("Formation"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true }
                        saveAdressUser()
                              },
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
                onClick = {navController.navigate("Country"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true }

                          },
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
                text = "Social Address",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}