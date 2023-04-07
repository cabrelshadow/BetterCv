package com.example.bettercvapp.screens




import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun Country(){

    var country by remember{ mutableStateOf("") }
    var city by remember{ mutableStateOf("") }
    var language by remember{ mutableStateOf("") }
    var level by remember{ mutableStateOf("") }




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

        Text(text = "Location",
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp
        )

        Text(text = "Country",

            textAlign = TextAlign.Start,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = country,
            onValueChange ={ country = it},
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
                    Icon(painter = painterResource(id = R.drawable.icon_count),
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
                Text(text = "Enter the name of your country",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(

                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "City ",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = city,
            onValueChange ={ city = it},
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
                    Icon(painter = painterResource(id = R.drawable.icon_appartment),
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
                Text(text = "Enter the name of your city",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "Language",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = language,
            onValueChange ={ language = it},
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
                    Icon(painter = painterResource(id = R.drawable.icon_language),
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
                Text(text = "Enter your language",
                    color = PlaceholderColor
                )
            },

            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Text(text = "Level",

            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            fontSize = 12.sp
        )

        TextField(value = level,
            onValueChange ={ level = it},
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
                    Icon(painter = painterResource(id = R.drawable.icon_elevation),
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
                Text(text = "Enter the level of your language",
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