package com.example.bettercvapp.screens.AddScreen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import com.example.bettercvapp.MyShape
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Competence(navController: NavController, context: Context) {
    var Competence by remember { mutableStateOf("") }
    var level by remember { mutableStateOf("") }

    var documentCount by remember { mutableStateOf(0) }
            FirebaseFirestore.getInstance().collection("Competence")
                .get()
                .addOnSuccessListener { documents ->
                    documentCount = documents.size()
                }
    val db = Firebase.firestore
    fun AddComIdDocument(collectionname:String,IdDoc:String,data:Map<String, Any>){
        val documentRef = db.collection(collectionname)
                            .document(IdDoc)
        documentRef.set(data)
            .addOnSuccessListener {
                Toast.makeText(context, "Enregistrement effectuée avec succès", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "L'enregistrement a échoué : ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    val competence = mapOf(
        "competence" to Competence,
        "level" to level,
    )

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
                                val id = documentCount+1
                                AddComIdDocument("Competence","Com$id",competence)
                              },
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

        },
        content = {it
            LazyColumn( contentPadding = PaddingValues(bottom = 40.dp)){
                stickyHeader {
                    Header(navController)
                }
                items(1) {
                    //Champ a remplir numero 1
                    Spacer(modifier = Modifier.height(80.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = Competence,
                            onValueChange = { Competence = it },
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
                                        Icons.Rounded.Star,
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
                                    text = "Enter your Competence",
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
                            value = level ,
                            onValueChange = { level = it },
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
                                    text = "Enter your Level",
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
                .background(com.example.bettercvapp.ui.theme.head),
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
                    text = "Competences",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }

        }
    }
}

@Composable
fun BottomBarC() {
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
