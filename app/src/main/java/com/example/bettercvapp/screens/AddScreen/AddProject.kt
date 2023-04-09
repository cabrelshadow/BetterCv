package com.example.bettercvapp.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddProject(navController: NavController) {
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
        Footer("    Add new project")
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateTextField(selectedDate: LocalDate?, onDateSelected: (LocalDate?) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        value = selectedDate?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) ?: "",
        label = { Text(text = stringResource(R.string.date)) },
        trailingIcon = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.DateRange, contentDescription = stringResource(R.string.select_date))
            }
        },
        onValueChange = {}
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        val now = LocalDate.now()
        (0..365).forEach { days ->
            val date = now.plusDays(days.toLong())
            DropdownMenuItem(onClick = {
                onDateSelected(date)
                expanded = false
            }) {
                Text(text = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            }
        }
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
               text = "Projet",
               fontFamily = Poppins,
               color = Color.Black,
               fontSize = 25.sp,
           )
       }
   }
}

@Composable
private fun EnterInfo(){
    var NameProject by remember { mutableStateOf("") }
    var Status by remember { mutableStateOf("") }
    var StartDate by remember { mutableStateOf("") }
    var EndDate by remember { mutableStateOf("") }
    var Partner by remember { mutableStateOf("") }
    var UrlProject by remember { mutableStateOf("") }
    var DescriptionOfProject by remember { mutableStateOf("") }


    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Name of Project",
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
            value = NameProject, onValueChange = { NameProject = it },
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

    //Spacer(modifier = Modifier.height(16.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Your status in Project",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = Status, onValueChange = { Status = it },
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
   // Spacer(modifier = Modifier.height(16.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Start date",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = StartDate, onValueChange = { StartDate = it },
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
    //Spacer(modifier = Modifier.height(16.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "End date",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = EndDate, onValueChange = { EndDate = it },
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
    //Spacer(modifier = Modifier.height(16.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Partner in Project",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = Partner, onValueChange = { Partner = it },
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
            text = "URL of project",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(Height)
            .padding(horizontal = 18.dp),

    ) {
       OutlinedTextField(
            value = UrlProject, onValueChange = { UrlProject = it },
           Modifier
               .width(350.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = true,

        )
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Description of project",
            fontFamily = Poppins,
            fontSize = 14.sp,
        )
    }
    //Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .height(150.dp)
            .padding(horizontal = 18.dp)
    ) {
        OutlinedTextField(
            value = DescriptionOfProject, onValueChange = { DescriptionOfProject = it },
            Modifier
                .width(350.dp)
                .height(150.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                unfocusedBorderColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
            ),
            shape = InputBoxShape.medium,
            singleLine = false
        )
    }

}
