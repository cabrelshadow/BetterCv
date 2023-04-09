package com.example.expprofessionelle

import android.widget.Toast
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
fun ProfessionalExpScreen(navController: NavController) {
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
        Footer("Add new Experiences")
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
                text = "Experience Professional",
                fontFamily = Poppins,
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
private fun EnterInfo(){
    val notification = remember{ mutableStateOf("") }
    if(notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value=""
    }
    var organisation by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var function by remember{ mutableStateOf("") }
    var startDate by remember{ mutableStateOf("") }
    var endDate by remember{ mutableStateOf("") }

Spacer(modifier = Modifier.height(70.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Name of Organisation",
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
            value = organisation, onValueChange = { organisation = it },
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
            text = "Status",
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
            value = status, onValueChange = { status = it },
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
            text = "Function",
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
            value = function, onValueChange = { function = it },
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
            text = "StartDate",
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
            value = startDate, onValueChange = { startDate = it },
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
            text = "EndDate",
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
            value = endDate, onValueChange = { endDate = it },
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