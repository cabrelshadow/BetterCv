package com.example.bettercvapp.screens

import android.annotation.SuppressLint
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ModelScreen(navController: NavController) {
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
            Column(modifier = Modifier.padding(10.dp))
        {

            Text("Choisissez votre modele",
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

            // Paragraphe
            Text("Better cv vous offre la possibilite de choisir un modele de cv en fonction de proffession ",
                fontSize = 20.sp,
                color = Textcolor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = ReemKufi,
                style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(5.dp))
            // Barre de recherche
            OutlinedTextField(
                value = search, onValueChange = {
                    search = it
                },
                label = {
                    Text(text = "Chercher un modele", color = Textcolor)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = PrimaryColor,
                    textColor = PrimaryColor

                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Text
                ),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search_96px),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))


            // Cartes clickable

            CardList(navController)
        }
        }
    )

}


@Composable
fun CardList(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
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
                    .width(150.dp)
                    .clickable {},
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv1),
                        contentDescription = "Photo 1",
                        modifier = Modifier
                            .height(100.dp)
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
                        Text(text = "Developer",
                            color = Color.Black,
                            fontSize =14.sp,
                        ) }

                }
            }
            //Carte numero 2
            Card(
                Modifier
                    .width(150.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv2),
                        contentDescription = "Photo 2",
                        modifier = Modifier
                            .height(100.dp)
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
                            text ="Infographic",
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
                    .width(150.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv3),
                        contentDescription = "Photo 3",
                        modifier = Modifier
                            .height(100.dp)
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
                            text = "Administrate of bd",
                            color = Color.Black
                        )
                    }
                }
            }
            //Carte numero 4
            Card(
                Modifier
                    .width(150.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = Color.White
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.cv4),
                        contentDescription = "Photo 3",
                        modifier = Modifier
                            .height(100.dp)
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
                            text = "Analyst",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
