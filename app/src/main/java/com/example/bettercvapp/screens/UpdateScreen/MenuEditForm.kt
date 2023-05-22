package com.example.bettercvapp.screens.UpdateScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.head

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UPMenuForm(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                backgroundColor = head /*Color(0xFF6B85C9)*/,
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "MODIFIE VOS INFORMATIONS",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            Divider(color = Color.Gray.copy(alpha = .4f))

            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 16.dp, bottom = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("UpProfileScreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Informations personnelles",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("UpFormationScreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icons8_school_26px),
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Education",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("Competence") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Competences",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("UpFormationScreen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = " Professional Experience",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("Recommendation") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Reference",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }



            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("AddProject") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Projet",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }


            //*****************************
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 8.dp)
                    .clickable(onClick = {
                        navController.navigate("AddressNumber") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Address",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}
