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
import com.example.bettercvapp.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 40.dp)
        ) {
            stickyHeader {
                TopBar()
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
        Footer("")
    }

}

@Composable
private fun TopBar(){
    Surface{
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            TextButton(
                onClick = {/*TODO*/ },
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
                text = "Profile",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}
@Composable
fun EnterInfo() {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var borndate by remember { mutableStateOf("") }
    var bornat by remember { mutableStateOf("") }
    var maritalstatus by remember { mutableStateOf("") }
    var numberChild by remember { mutableStateOf("") }
    var drivinglicence by remember { mutableStateOf("") }


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
            value = firstname, onValueChange = { firstname = it },
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
}

@Composable
fun Footer( nom : String) {
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
            onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(75.dp, 0.dp)
                //.background(MaterialTheme.colors.primary)
                .height(35.dp),
            shape = InputBoxShape.medium,
        ) {
            Text(
                text = "Save and Continue",
                color = Color.White,
            )
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