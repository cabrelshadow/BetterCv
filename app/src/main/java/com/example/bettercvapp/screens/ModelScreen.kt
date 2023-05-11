package com.example.bettercvapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.example.bettercvapp.ui.theme.*

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

                    Spacer(Modifier.weight(1f))

                }

            }
        },

        content = { Column(modifier = Modifier.padding(16.dp))
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
            Spacer(modifier = Modifier.height(40.dp))

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
            Spacer(modifier = Modifier.height(50.dp))


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

            CardList()

            Spacer(modifier = Modifier.height(60.dp))
            // Bouton
            Button(
                onClick = { /* action lors du clic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PrimaryColor,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 14.dp)
            ) {
                Text("Commencer a rediger votre cv",fontFamily = Poppins)
            }
        }
        }
    )

}


@Composable
fun CardList() {
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
                    .clickable { /* Action à définir */ },
                backgroundColor = LightTextColor
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.devellopeur),
                        contentDescription = "Photo 1",
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text("Devellopeur",
                        color = Textcolor,
                        modifier = Modifier.padding(top = 12.dp),
                        fontSize =14.sp,
                        fontFamily = ReemKufi,
                        style = MaterialTheme.typography.h3)
                }
            }
            //Carte numero 2
            Card(
                Modifier
                    .width(150.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = LightTextColor
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.projet),
                        contentDescription = "Photo 2",
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Chef de projet TI",
                        color = Textcolor,
                        modifier = Modifier.padding(top = 12.dp),
                        fontSize =14.sp,
                        fontFamily = ReemKufi,
                        style = MaterialTheme.typography.h3)
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
                backgroundColor = LightTextColor
            ) {
                Column(Modifier.padding(8.dp)) {
                    Image(
                        painterResource(R.drawable.devellopeur),
                        contentDescription = "Photo 3",
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Administrateur de bd",
                        color = Textcolor,
                        modifier = Modifier.padding(top = 12.dp),
                        fontSize =14.sp,
                        fontFamily = ReemKufi,
                        style = MaterialTheme.typography.h3)
                }
            }
            //Carte numero 4
            Card(
                Modifier
                    .width(150.dp)
                    .clickable { /* Action à définir */ },
                backgroundColor = LightTextColor
            ) {
                Column(
                    Modifier
                        .padding(8.dp)
                        .wrapContentSize()
                        .clickable { /* Action à définir */ },


                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Ajouter une nouvelle carte",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "Ajouter un Domanie de proffession",
                        color = Textcolor,
                        modifier = Modifier.padding(top = 12.dp),
                        fontSize =14.sp,
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}