package com.example.bettercvapp.screens

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.DateRange
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
import com.example.bettercvapp.Height
import com.example.bettercvapp.MyShape
import com.example.bettercvapp.R
import com.example.bettercvapp.showdata.DataViewModel
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpProject(navController: NavController,
              context: Context,
              dataViewModel: DataViewModel = viewModel()
) {

    val db = Firebase.firestore
    var documentCount by remember { mutableStateOf(0) }

    FirebaseFirestore.getInstance().collection("Project")
        .get()
        .addOnSuccessListener { documents ->
            documentCount = documents.size()
        }
    val compet=db.collection("Project").document("Project$documentCount")


    //declaration pour obtenir les valeurs du projet
    val getData = dataViewModel.state3.value

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
    var NameProject by remember { mutableStateOf("") }
    var Status by remember { mutableStateOf("") }
    var StartDate by remember { mutableStateOf("") }
    var EndDate by remember { mutableStateOf("") }
    var Partner by remember { mutableStateOf("") }
    var UrlProject by remember { mutableStateOf("") }
    var DescriptionOfProject by remember { mutableStateOf("") }
    var change by remember { mutableStateOf("") }
    var change1 by remember { mutableStateOf("") }


    if(date.value.isNullOrEmpty()){
        change = getData.StartDate
    }else{
        change = date.value
    }

    if(date2.value.isNullOrEmpty()){
        change1 = getData.EndDate
    }else{
        change1 = date2.value
    }
    //variable de manipulation de fire store



    fun modif(){
        if(NameProject.isEmpty()){
            NameProject=getData.NameProject
        }
        if (Status.isEmpty()){
            Status = getData.Status
        }
        if(StartDate.isEmpty()){
            StartDate = getData.StartDate
        }
        if(EndDate.isEmpty()){
            EndDate = getData.EndDate
        }
        if(Partner.isEmpty()){
            Partner = getData.Partner
        }
        if(UrlProject.isEmpty()){
            UrlProject = getData.UrlProject
        }
        if(DescriptionOfProject.isEmpty()){
            DescriptionOfProject = getData.DescriptionOfProject
        }
    }

    //fonction d'ajout a la base de donne fire store
    fun UpdatProject(){
        val newpro = hashMapOf<String, Any>(
            "NameProject" to NameProject,
            "Status" to Status,
            "StartDate" to change,
            "EndDate" to change1,
            "Partner" to Partner,
            "UrlProject" to UrlProject,
            "DescriptionOfProject" to DescriptionOfProject,
        )
        compet.update(newpro)
            .addOnSuccessListener {
                Toast.makeText(context, "La mise à jour a été effectuée avec succès", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "La mise à jour a échoué : ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
    //Partir pour enter les données(Champs de texte)
    Scaffold(bottomBar = {
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
                            UpdatProject()
                        },
                        Modifier
                            .height(40.dp)
                            .width(150.dp)
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
                }
            }

    },
        content = {it
            LazyColumn( contentPadding = PaddingValues(bottom = 40.dp)){
                stickyHeader {
                    Header(navController)
                }
                items(1){
                    //Champ a remplir numero 1
                    Spacer(modifier = Modifier.height(60.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = NameProject,
                            onValueChange = { NameProject = it },
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
                                        painter = painterResource(id = R.drawable.icons8_test_passed_50px),
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
                                    text = getData.NameProject,
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
                            value = Status,
                            onValueChange = { Status = it },
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
                                        painter = painterResource(id = R.drawable.icons8_test_passed_50px),
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
                                    text = getData.Status,
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
                            value = Partner,
                            onValueChange = { Partner = it },
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
                                        painter = painterResource(id = R.drawable.icons8_test_passed_50px),
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
                                    text = getData.Partner,
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
                            value = UrlProject,
                            onValueChange = { UrlProject = it },
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
                                        painter = painterResource(id = R.drawable.icons8_test_passed_50px),
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
                                    text = getData.UrlProject,
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

                    //Champ a remplir numero 5
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = StartDate,
                            onValueChange = { StartDate = it },
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
                                    text = getData.StartDate,
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
                                Modifier
                                    .size(40.dp)
                                    .align(Alignment.Bottom)
                                    .offset((-13).dp, 10.dp)
                            )
                        }
                    }

                    //Champ a remplir numero 6
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = EndDate ,
                            onValueChange = { EndDate = it },
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
                                    text = getData.EndDate,
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
                                Modifier
                                    .size(40.dp)
                                    .align(Alignment.Bottom)
                                    .offset((-13).dp, 10.dp)
                            )
                        }
                    }
                    //Champ a remplir numero 7
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = DescriptionOfProject,
                            onValueChange = { DescriptionOfProject = it },
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
                            singleLine = false,
                            leadingIcon = {
                                Row(
                                    modifier = Modifier.padding(start = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icons8_test_passed_50px),
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
                                    text = getData.DescriptionOfProject,
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
                onClick = {navController.navigate("UPMenuForm"){
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
                    text = "Project",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 50.sp,
                )
            }

        }
    }
}