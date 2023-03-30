package com.example.bettercvapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.*

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(id = R.drawable.ko), contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "BIENVENUE SUR BETTERCV",
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins
        )
    }
    Box(contentAlignment = Alignment.BottomCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {





            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = BottomBoxShape.medium
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Se Connecter Avec Son EMAIL",
                        color = LightTextColor,
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    OutlinedTextField(
                        value = email, onValueChange = {
                            email = it
                        },
                        label = {
                            Text(text = "Addresse Email", color = PrimaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            textColor = Textcolor

                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                            KeyboardType.Email
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_email),
                                contentDescription = "",
                                tint = PrimaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )

                    OutlinedTextField(
                        value = password, onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Mot de Passe", color = PrimaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            textColor =  Textcolor
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password),
                                contentDescription = "",
                                tint = PrimaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                if (!isPasswordOpen) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye_open),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye_close),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp)
                    ) {

                        Text(text = "Login", fontFamily = Poppins)
                    }


                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(vertical = 0.dp)
                    ) {
                        Text(
                            text = "Mot de passe oublie ?",
                            color = LightTextColor,
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 26.dp)
                        )
                    }
                    TextButton(
                        onClick = {
                            navController.navigate("RegisterScreen"){
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        contentPadding = PaddingValues(vertical = 0.dp)
                    ) {
                        Text(
                            text = "Avez-vous un comptes ? Se connecter",
                            color = LightTextColor,
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}



