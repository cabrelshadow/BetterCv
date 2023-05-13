package com.example.bettercvapp.screens.AddScreen

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
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Formation(navController: NavController){
    var school by remember{ mutableStateOf("") }
    var domainOfStudy by remember{ mutableStateOf("") }
    var diploma by remember{ mutableStateOf("") }
    var startdate by remember{ mutableStateOf("") }
    var enddate by remember{ mutableStateOf("") }
    var obtainresult by remember{ mutableStateOf("") }

    val db = Firebase.firestore
    val formation = db.collection("formation")
    //fonction d'ajout a la base de donne fire store
    fun saveformation(){
        val newformation = hashMapOf(
            "school" to school,
            "domainOfStudy" to domainOfStudy,
            "diploma" to diploma,
            "startdate" to startdate,
            "enddate" to enddate,
            "obtainresult" to obtainresult
        )
        formation.add(newformation)
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
                            text = "School of Your Formation",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = school,
                            onValueChange = { school = it },
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
                            text = "Domain of your study",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = domainOfStudy, onValueChange = { domainOfStudy = it },
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
                            text = "Diploma",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = diploma, onValueChange = { diploma = it },
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
                            text = "Start Date",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = startdate, onValueChange = { startdate = it },
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
                            text = "End Date",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = enddate, onValueChange = { enddate = it },
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
                            text = "Mention of your Diploma",
                            fontFamily = Poppins,
                            fontSize =14.sp,
                        )
                    }
                    //Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier
                            .height(Height)
                            .padding(horizontal = 18.dp)
                    ) {
                        OutlinedTextField(
                            value = obtainresult, onValueChange = { obtainresult = it },
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
                    onClick = { if(school.isEmpty() || domainOfStudy.isEmpty() || diploma.isEmpty()
                        || obtainresult.isEmpty() || startdate.isEmpty() || enddate.isEmpty()
                    ){
                        showDialog.value = true
                    }else{
                        saveformation()
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
                                onClick = {  navController.navigate("ProfessionalExpScreen"){
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
                onClick = {navController.navigate("AddressNumber"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true }},
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
                text = "Formation",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}
