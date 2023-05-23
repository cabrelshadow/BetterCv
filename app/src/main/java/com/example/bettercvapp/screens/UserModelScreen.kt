package com.example.bettercvapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.PrimaryColor
import com.example.bettercvapp.ui.theme.ReemKufi
import com.example.bettercvapp.ui.theme.Textcolor

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UserModelScreen(navController: NavController){

    var search by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            Box(
                Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {

                    IconButton(onClick = {navController.navigate("HomeScreens"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true } }) {

                        Icon(Icons.Rounded.ArrowBack, contentDescription = stringResource(R.string.arrow))
                    }

                    Text(text = "Retour",
                        color = Textcolor,
                        modifier = Modifier.padding(top = 12.dp),
                        fontSize =20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = ReemKufi,
                        style = MaterialTheme.typography.h3
                    )

                }

            }
        },

        content = {

            Column(
                modifier = Modifier.padding(10.dp)
            )

            {

                Text("Mes models de Cv",
                    fontSize = 28.sp,
                    color = PrimaryColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = ReemKufi,
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(5.dp))



                // Cartes clickable

                CardList2(navController)
            }
        }
    )

}


@Composable
fun CardList2(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(30.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Carte numero 1
            Card(
                Modifier
                    .width(140.dp)
                    .clickable {},
                backgroundColor = Color.White,

            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv1),
                        contentDescription = "Photo 1",
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                            .clickable {}
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    TextButton(onClick = {
                        navController.navigate("CvScreen"){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true }
                    } ){
                        Text(text = "Developeur",
                            color = Color.Black,
                            fontSize =14.sp,
                        ) }

                }
            }
            //Carte numero 2
            Card(
                Modifier
                    .width(130.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.designer1),
                        contentDescription = "Photo 2",
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    TextButton(onClick = {
                        navController.navigate("CvScreen2"){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true }
                    }){
                        Text(
                            text ="UI/UX Designer",
                            color = Color.Black,
                            fontSize =14.sp,
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            //Carte numero 3
            Card(
                Modifier
                    .width(140.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv3),
                        contentDescription = "Photo 3",
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    TextButton(onClick = {
                        navController.navigate("CvScreen3"){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true }
                    }){
                        Text(
                            text = "Administrateur de bd",
                            color = Color.Black
                        )
                    }
                }
            }
            //Carte numero 4
            Card(
                Modifier
                    .width(130.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv4),
                        contentDescription = "Photo 3",
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    TextButton(onClick = {
                        navController.navigate("CvScreen4"){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true }
                    }){
                        Text(
                            text = "Analyste",
                            color = Color.Black
                        )
                    }
                }
            }
        }


    }

}