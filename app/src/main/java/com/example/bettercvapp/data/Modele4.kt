package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CvScreen4(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "CV Analysts") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate("ModelScreen"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true }}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                }
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                elevation = 8.dp,
                backgroundColor = Color.White
            ) {
                Row(modifier = Modifier.padding(32.dp)) {
                    Column(
                        modifier = Modifier.weight(2f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Nom Prénom",
                            style = MaterialTheme.typography.h3,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 16.dp),

                            )
                        Text(
                            text = "Designer Graphique",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 32.dp),
                        )

                        SectionTitle4(title = "Compétences professionnelles")

                        Competences4()

                        SectionTitle4(title = "Formation")

                        Formation4()

                        SectionTitle4(title = "Langues")

                        Langues4()
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            painter = painterResource(id = com.example.bettercvapp.R.drawable.usetr),
                            contentDescription = "Photo de profil",
                            modifier = Modifier
                                .size(152.dp, 152.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Appliquer ce Model")
        }
    }
}

@Composable
fun Competences4() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "- Design graphique")
        Text(text = "- Illustration")
        Text(text = "- Conception de logos")
        Text(text = "- HTML et CSS")
        Text(text = "- Adobe Creative Suite")
// Ajoutez d'autres éléments en fonction de vos compétences
    }
}

@Composable
fun Formation4() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Master en design graphique", fontWeight = FontWeight.Bold)
        Text(text = "École de design XYZ, Dates de début et de fin")
        Text(text = "Matieres étudiées :", fontWeight = FontWeight.Bold)
        Text(text = "- Typographie")
        Text(text = "- Histoire de l'art")
        Text(text = "- Design d'interface")
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

@Composable
fun Langues4() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues étrangères :", fontWeight = FontWeight.Bold)
        Text(text = "- Anglais : Courant")
        Text(text = "- Espagnol : Intermédiaire")
        Text(text = "Certifications obtenues :", fontWeight = FontWeight.Bold)
        Text(text = "- Adobe Certified Expert")
// Ajoutez d'autres éléments en fonction de vos compétences linguistiques
    }
}

@Composable
fun SectionTitle4(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}
