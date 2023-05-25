package com.example.bettercvapp.screens.UpdateScreen

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build.ID
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bettercvapp.MyShape
import com.example.bettercvapp.R
import com.example.bettercvapp.showdata.DataViewModel
import com.example.bettercvapp.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpFormationScreen(navController: NavController,
              context : Context,
              dataViewModel: DataViewModel = viewModel()
) {
    val db = Firebase.firestore
    var documentCount by remember { mutableStateOf(0) }

    FirebaseFirestore.getInstance().collection("Formation")
        .get()
        .addOnSuccessListener { documents ->
            documentCount = documents.size()
        }
    val compet=db.collection("Formation").document("For$documentCount")


    //declaration pour obtenir les valeurs du profil KnM0GVz6QztY1XftOvbE
    val getData = dataViewModel.state2.value

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
    var school by remember{ mutableStateOf("") }
    var domainOfStudy by remember{ mutableStateOf("") }
    var diploma by remember{ mutableStateOf("") }
    var startdate by remember{ mutableStateOf("") }
    var enddate by remember{ mutableStateOf("") }
    var obtainresult by remember{ mutableStateOf("") }
    var change by remember { mutableStateOf("") }
    var change1 by remember { mutableStateOf("") }

    //variable de manipulation de fire store
    if(date.value.isNullOrEmpty()){
        change = getData.startdate
    }else{
        change = date.value
    }

    if(date2.value.isNullOrEmpty()){
        change1 = getData.enddate
    }else{
        change1 = date2.value
    }

    //condition pour modification des eléments du profil Cv
    fun modif(){
        if(school.isEmpty()){
            school=getData.school
        }
        if (domainOfStudy.isEmpty()){
            domainOfStudy = getData.domainOfStudy
        }
        if(diploma.isEmpty()){
            diploma = getData.diploma
        }
        if(startdate.isEmpty()){
            startdate = getData.startdate
        }
        if(enddate.isEmpty()){
            enddate = getData.enddate
        }
        if(obtainresult.isEmpty()){
            obtainresult = getData.obtainresult
        }
    }

    //fonction pour la mise a jour des champs du profile du Cv
    fun UpdateFor(){
        val updateProfile = hashMapOf<String, Any>(
            "school" to school,
            "domainOfStudy" to domainOfStudy,
            "diploma" to diploma,
            "startdate" to change,
            "enddate" to change1,
            "obtainresult" to obtainresult,
        )
        compet.update(updateProfile)
            .addOnSuccessListener {
                Toast.makeText(context, "La mise à jour a été effectuée avec succès", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "La mise à jour a échoué : ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    //Partir pour enter les données(Champs de texte)

    Scaffold (
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
                            modif()
                            UpdateFor()
                        },
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
                items(1) {
                    //Champ a remplir numero 1
                    Spacer(modifier = Modifier.height(60.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = school,
                            onValueChange = { school = it },
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
                                    text = getData.school,
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
                            value = domainOfStudy ,
                            onValueChange = { domainOfStudy = it },
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
                                        Icons.Rounded.Info,
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
                                    text = getData.domainOfStudy,
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
                            value = diploma ,
                            onValueChange = { diploma = it },
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
                                        Icons.Filled.Done,
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
                                    text = getData.diploma,
                                    color = Color.Black
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Poppins
                            )
                        )
                    }//Champ a remplir numero 4
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = obtainresult ,
                            onValueChange = { obtainresult = it },
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
                                    text = getData.obtainresult,
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
                            value = startdate,
                            onValueChange = { startdate = it },
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
                                    text = "start Date : $change",
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

                    //Champ a remplir numero 6
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(horizontal = 18.dp)
                    ) {
                        TextField(
                            value = enddate,
                            onValueChange = { enddate = it },
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
                                    text = "End Date : $change1",
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
                    text = "Formation",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 35.sp,
                )
            }
        }
    }
}