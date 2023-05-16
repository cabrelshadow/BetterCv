package com.example.expprofessionelle


import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfessionalExpScreen(navController: NavController, context : Context) {
    
    //function pour le calendrier
    val year : Int
    val month: Int
    val day :Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val date2 = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, yeah:Int, month:Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$yeah"
        },year,month,day
    )
    val datePickerDialog2 = DatePickerDialog(
        context,
        { _: DatePicker, yeah:Int, month:Int, dayOfMonth: Int ->
            date2.value = "$dayOfMonth/$month/$yeah"
        },year,month,day
    )
    

    //variable pour stocker les données
    var organisation by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var function by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    //variacle de manipulation de fire store
    val db = Firebase.firestore
    val expro = db.collection("ExperiencePro")

    //Fonction de sauvegade de donné dans la base de données
    fun saveExpro() {
        val newExpro = hashMapOf(
            "organisation" to organisation,
            "status" to status,
            "function" to function,
            "startDate" to startDate,
            "endDate" to endDate
        )
        expro.add(newExpro)
    }
    ///Partir pour enter les données(Champs de texte)
    
    Scaffold(

        bottomBar = { BottomBar() },
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
                            value = organisation,
                            onValueChange = { organisation = it },
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
                                    text = "Enter the name of your Organisation",
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
                            value = status ,
                            onValueChange = { status = it },
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
                                    text = "Enter your Status in Experience",
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
                            value = function ,
                            onValueChange = { function = it },
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
                                        painter = painterResource(id = R.drawable.icons8_school_26px),
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
                                    text = "Enter your function in experience",
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
                            value = startDate,
                            onValueChange = { startDate = it },
                            enabled = false,
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
                                //unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = InputBoxShape.medium,
                            singleLine = true,
                            leadingIcon = {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .weight(1f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icons8_pay_date_50px),
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
                                    text = "start Date : ${date.value}",
                                    color = Color.Black,
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Poppins
                            ),
                        )
                        IconButton(onClick = {
                            datePickerDialog.show()
                        }) {
                            Icon(Icons.Rounded.DateRange,
                                contentDescription = "Date Start",
                                Modifier.size(40.dp)
                                    .align(Alignment.Bottom)
                                    .offset((-13).dp,10.dp)
                            )
                        }
                    }

                    //Champ a remplir numero 5
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = endDate,
                            onValueChange = { endDate = it },
                            enabled = false,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 10.dp)
                                .weight(1f),

                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                backgroundColor = PlaceholderColor,
                                cursorColor = PrimaryColor,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = InputBoxShape.medium,
                            singleLine = true,
                            leadingIcon = {
                                Row(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .weight(1f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icons8_pay_date_50px),
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
                                    text = "End Date : ${date2.value}",
                                    color = Color.Black,
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Poppins
                            ),
                        )
                        IconButton(onClick = {
                            datePickerDialog2.show()
                        }) {
                            Icon(Icons.Rounded.DateRange,
                                contentDescription = "Date Start",
                                Modifier.size(40.dp)
                                    .align(Alignment.Bottom)
                                    .offset((-13).dp,10.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(65.dp))

                }
            }
        }
    )
}


//entete de page
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
                    text = "Experience Professionnelle",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 25.sp,
                )
            }

        }
    }
}
//pied de page
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
                    .height(40.dp)
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
                    fontSize = 15.sp,
                    fontFamily = Poppins
                )
            }
            //add button
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .height(40.dp)
                    .width(115.dp)
                    .align(Alignment.CenterVertically),
                shape = MyShape
            )
            {
                Icon(Icons.Rounded.Add, contentDescription = "")
                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = Poppins
                )
            }
        }
    }
}