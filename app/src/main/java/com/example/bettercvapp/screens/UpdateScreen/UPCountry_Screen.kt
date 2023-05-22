package com.example.bettercvapp.screens.UpdateScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bettercvapp.MyShape
import com.example.bettercvapp.R
import com.example.bettercvapp.showdata.DataViewModel
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UPCountryScreen (navController: NavController,
                     context : Context,
                     dataViewModel: DataViewModel = viewModel()
){

    //declaration pour obtenir les valeurs du profil
    val getData = dataViewModel.state7.value
    //variable pour stocker les données
    var country by remember{ mutableStateOf("") }
    var city by remember{ mutableStateOf("") }
    var language by remember{ mutableStateOf("") }
    var level by remember{ mutableStateOf("") }


    //variacle de manipulation de fire store
    val db = Firebase.firestore
    val docRef = db.collection("Address").document("")

    //Fonction de sauvegade de donné dans la base de données
    /*fun saveCountry(){
        val newCountry = hashMapOf(
            "country" to country,
            "city" to city,
            "language" to language,
            "level" to level
        )
        count.add(newCountry)
    }*/

    fun modif(){
        if(country.isEmpty()){
            country=getData.country
        }
        if (city.isEmpty()){
            city = getData.city
        }
        if(language.isEmpty()){
            language = getData.language
        }
        if(level.isEmpty()){
            level = getData.level
        }

    }

    fun Updatecoun(){
        val updateProfile = hashMapOf<String, Any>(
            "firstname" to country,
            "lastname" to city,
            "borndate" to language,
            "bornat" to level,

        )
        docRef.update(updateProfile)
            .addOnSuccessListener {
                Toast.makeText(context, "La mise à jour a été effectuée avec succès", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "La mise à jour a échoué : ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    //Partie pour entrer les données (champ de texte)


    Scaffold(
        bottomBar = {

            Surface(color = Color.White,
                elevation = 10.dp) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            modif()
                            Updatecoun()
                        },
                        Modifier
                            .height(40.dp)
                            .width(120.dp)
                            .align(Alignment.CenterVertically),
                        //shape = InputBoxShape.medium,
                        shape = MyShape,
                    )
                    {
                        Icon(Icons.Rounded.ArrowDropDown, contentDescription = "")
                        Text(
                            text = "Update",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = Poppins
                        )
                    }
                    //add button

                }
            }

        },
        content = {it
            LazyColumn( contentPadding = PaddingValues(bottom = 40.dp)){
                stickyHeader {
                    Header(navController)
                }
                items(1) {
                    //Champ a remplir numero 1
                    Spacer(modifier = Modifier.height(60.dp))
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
                                    text = getData.country,
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
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = city ,
                            onValueChange = { city = it },
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
                                        painter = painterResource(id = R.drawable.icon_appartment),
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
                                    text = getData.city,
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
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = language ,
                            onValueChange = { language = it },
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
                                        painter = painterResource(id = R.drawable.icon_language),
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
                                    text = getData.language,
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
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = level,
                            onValueChange = { level = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 10.dp)
                                .weight(1f),

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
                                        painter = painterResource(id = R.drawable.icon_elevation),
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
                                    text = getData.level,
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
                    Spacer(modifier = Modifier.height(65.dp))

                }
            }
        }
    )
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
                onClick = {navController.navigate("MenuForm"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true }},
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.app_name),
                    Modifier.size(30.dp),
                    tint = Color.White
                )
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

@Composable
fun BottomBar() {
    Surface(color = Color.White,
        elevation = 10.dp) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .height(50.dp)
                    .width(115.dp)
                    .align(Alignment.CenterVertically),
                //shape = InputBoxShape.medium,
                shape = MyShape,
            )
            {
                Icon(Icons.Rounded.ArrowDropDown, contentDescription = "")
                Text(
                    text = "Save",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Poppins
                )
            }
            //add button
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .height(50.dp)
                    .width(115.dp)
                    .align(Alignment.CenterVertically),
                shape = MyShape
            )
            {
                Icon(Icons.Rounded.Add, contentDescription = "")
                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Poppins
                )
            }
        }
    }
}