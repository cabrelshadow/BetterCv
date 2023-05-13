package com.example.better_cv.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.Height
import com.example.bettercvapp.R
import com.example.bettercvapp.data.DataProfil
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(navController: NavController) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var borndate by remember { mutableStateOf("") }
    var bornat by remember { mutableStateOf("") }
    var maritalstatus by remember { mutableStateOf("") }
    var numberChild by remember { mutableStateOf("") }
    var drivinglicence by remember { mutableStateOf("") }

    val db = Firebase.firestore
    val profil = db.collection("Profile")

    fun saveProfile(){
        val newProfil = hashMapOf(
            "firstname" to firstname,
            "lastname" to lastname,
            "borndate" to borndate,
            "maritalstatus" to maritalstatus,
            "numberChild" to numberChild,
            "drivinglicence" to drivinglicence,

        )
        profil.add(newProfil)
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
                            text = "Your First Name",
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
                            value = firstname,
                            onValueChange = { firstname = it },
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
                            text = "Your Last Name",
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
                            value = lastname, onValueChange = { lastname = it },
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
                            text = "Your Born Date",
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
                            value = borndate, onValueChange = { borndate = it },
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
                            text = "Place Of Birth",
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
                            value = bornat, onValueChange = { bornat = it },
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
                            text = "Your Marital Status",
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
                            value = maritalstatus, onValueChange = { maritalstatus = it },
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
                            text = "Number of your Child",
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
                            value = numberChild, onValueChange = { numberChild = it },
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
                            text = "Your Type Of Driving License",
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
                            value = drivinglicence, onValueChange = { drivinglicence = it },
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
        //Footer(navController)
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
                    onClick = { if(firstname.isEmpty() || lastname.isEmpty() || borndate.isEmpty() ||
                                    bornat.isEmpty() || drivinglicence.isEmpty() || numberChild.isEmpty()
                        || maritalstatus.isEmpty()
                            ){
                        showDialog.value = true
                    }else{
                        saveProfile()
                        sucess.value = true
                    }
                        saveProfile()
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
                                onClick = {  navController.navigate("Country"){
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
fun TopTitleBar(){
    Surface() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Profile",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
 fun TopBar(navController: NavController){
    Surface{
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            TextButton(
                onClick = {navController.navigate("HomeScreens"){
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