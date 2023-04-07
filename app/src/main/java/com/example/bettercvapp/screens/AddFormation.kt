package com.example.bettercvapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.*


@Composable
fun Formation(){

    var school by remember{ mutableStateOf("") }
    var domainOfStudy by remember{ mutableStateOf("") }
    var diploma by remember{ mutableStateOf("") }
    var startdate by remember{ mutableStateOf("") }
    var enddate by remember{ mutableStateOf("") }
    var obtainresult by remember{ mutableStateOf("") }



    Box(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
        ) {

            IconButton(onClick = {  }) {

                Icon(Icons.Rounded.ArrowBack, contentDescription = stringResource(R.string.arrow))
            }

            Text(text = "Back",
                fontFamily = Poppins,
                color = PrimaryColor,
                modifier = Modifier.padding(top = 12.dp),
                fontSize =16.sp
            )

            Spacer(Modifier.weight(1f))

            Text(text = "Save draft",
                fontFamily = Poppins,
                color = Purple700,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 5.dp),
                fontSize = 16.sp
            )

        }

    }



    Column(

        modifier = Modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.Start
    ){

        Text(text = "Formations",
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp
        )

        Text(text = "School",

            textAlign = TextAlign.Start,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = school,
            onValueChange ={ school = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                cursorColor = PrimaryColor,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_building_with_rooftop_terrace_24px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter your name school",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(

                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "Domain Of Study",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = domainOfStudy,
            onValueChange ={ domainOfStudy = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_school_26px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter your Domain of study",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "Diploma",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = diploma,
            onValueChange ={ diploma = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_graduation_scroll_30px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter your diploma",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "Start Date",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = startdate,
            onValueChange ={ startdate = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_pay_date_50px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter the start date",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "End date",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = enddate,
            onValueChange ={ enddate = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_pay_date_50px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter the end date",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )


        Text(text = "Obtained Result",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = obtainresult,
            onValueChange ={ obtainresult = it},
            modifier = Modifier
                .fillMaxWidth()
                // .size(50.dp)
                .height(90.dp)
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = BackgroundColor,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            //  shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(

                    modifier = Modifier.padding(start = 8.dp),
                    //verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(painter = painterResource(id = R.drawable.icons8_test_passed_50px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(BackgroundColor)
                    )
                }
            },

            placeholder = {
                Text(text = "Enter the obtained result",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )



    }
    Spacer(Modifier.height(30.dp))

    Column(

        modifier = Modifier
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        //  Box(
        //     Modifier
        //         .size(46.dp)
        //         .clip(CircleShape)
        //.background(Color.Cyan)
        //        .padding(top = 8.dp),

        //      contentAlignment = Alignment.Center,

        //   ){

        // Icon(Icons.Rounded.Add, contentDescription = stringResource(R.string.add))



        //  }

        //  Spacer(Modifier.height(10.dp))

        Button(onClick = { },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple700
            ),
            modifier = Modifier
                .clip(CircleShape)
                .padding(top = 10.dp)
            //.size(30.dp)

        ) {

            Text(text = "+",
                fontFamily = Poppins,
                color = PrimaryColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }



        Text(stringResource(R.string.add_another_formation))

        Spacer(Modifier.height(50.dp))

        Button(onClick = {  },


            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(horizontal = 34.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple700
            ),
            contentPadding = PaddingValues(vertical = 10.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )



        ) {

            Text(text = "Save & Continue",
                fontFamily = Poppins,
                color = PrimaryColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }


    }



}