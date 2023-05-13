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
fun Recommendation(navController: NavController) {
    var PersonName by remember { mutableStateOf("") }
    var Relationship by remember { mutableStateOf("") }
    var ResearchPost by remember{ mutableStateOf("") }
    var Message by remember{ mutableStateOf("") }
    var Number by remember{ mutableStateOf("") }


    val db = Firebase.firestore
    val recom = db.collection("recommandation")

    fun saveRecom(){
        val newRecom = hashMapOf(
            "PersonName" to PersonName,
            "Relationship" to Relationship,
            "ResearchPost" to ResearchPost,
            "Message" to Message,
            "Number" to Number
        )
        recom.add(newRecom)
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

                    val notification = remember{ mutableStateOf("") }
                    if(notification.value.isNotEmpty()){
                        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
                        notification.value=""
                    }

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
                            value = Number, onValueChange = {Number = it },
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
        //Footer("Add new Recommendation",navController,"HomeScreens")

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
                val showDialog = remember { mutableStateOf(false) }
                val sucess = remember { mutableStateOf(false) }
                Button(
                    onClick = { if(PersonName.isEmpty() || Relationship.isEmpty()
                        || ResearchPost.isEmpty() || Message.isEmpty() || Number.isEmpty()
                    ){
                        showDialog.value = true
                    }else{
                        saveRecom()
                        sucess.value=true
                    }
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

                if (sucess.value) {
                    AlertDialog(
                        onDismissRequest = { showDialog.value = false },
                        title = { Text(text = "Information") },
                        text = { Text(text = "enregistrer avec succes") },
                        confirmButton = {
                            Button(
                                onClick = {  navController.navigate("HomeScreens"){
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true } },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                            ) {
                                Text(text = "OK")
                            }
                        }
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

