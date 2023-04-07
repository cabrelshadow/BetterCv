package com.example.expprofessionelle

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expprofessionelle.ui.theme.ExpProfessionelleTheme
import com.example.expprofessionelle.ui.theme.Purple200

@Composable
@Preview
fun ProfessionalExpScreen(){
    val notification = rememberSaveable{ mutableStateOf("") }
    if(notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value=""
    }
    var organisation by rememberSaveable{ mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }
    var function by rememberSaveable{ mutableStateOf("") }
    var startDate by rememberSaveable{ mutableStateOf("") }
    var endDate by rememberSaveable{ mutableStateOf("") }




    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp),


        ){

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top=14.dp)


        ){
            IconButton(onClick = {  }) {

                Icon(Icons.Rounded.ArrowBack, contentDescription = stringResource(R.string.arrow))
            }
            Text (text ="Back",
                modifier = Modifier.padding(top=8.dp))

            Spacer(Modifier.weight(1f))

            Text (text ="Save",
                modifier = Modifier.padding(top= 8.dp)
                    .padding(horizontal = 5.dp),
                fontSize = 16.sp)

        }
        Text(text = "Professional Experience",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp))

        Spacer(Modifier.height(40.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically){

            Text(text= "Organisation", modifier= Modifier.width(100.dp))
            TextField(value = organisation, onValueChange = {organisation=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White
            )
            )
        }
        Spacer(Modifier.height(40.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically){

            Text(text= "Status", modifier= Modifier.width(100.dp))
            TextField(value = status, onValueChange = {status=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Transparent
            )
            )
        }



        Spacer(Modifier.height(40.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically){

            Text(text= "Function", modifier= Modifier.width(100.dp))
            TextField(value = function, onValueChange = {function=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White
            )
            )
        }
        Spacer(Modifier.height(40.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically){

            Text(text= "Starting Date", modifier= Modifier.width(100.dp))
            TextField(value = startDate, onValueChange = {startDate=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White
            )
            )
        }


        Spacer(Modifier.height(40.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically){

            Text(text= "Ending Date", modifier= Modifier.width(100.dp))
            TextField(value = endDate, onValueChange = {endDate=it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = Color.White,

                    )
            )
        }
    }

    Column (
        modifier = Modifier
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Button(onClick = { },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple200
            ),
            modifier = Modifier
                .clip(CircleShape)
                .padding(top = 2.dp)
            //.size(30.dp)

        ) {

            Text(text = "+",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }


        Text(stringResource(R.string.add_another_professionalExp))

        Spacer(Modifier.height(50.dp))

        Button(onClick = {  },


            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(horizontal = 34.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple200
            ),
            contentPadding = PaddingValues(vertical = 10.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )



        ) {

            Text(text = "Save & Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun showPreview(){
    ExpProfessionelleTheme {
        ProfessionalExpScreen()
    }
}