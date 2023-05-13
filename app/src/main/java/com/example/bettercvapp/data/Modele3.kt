package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CvScreen3(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Administrate BD") },
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
                .padding(vertical = 16.dp, horizontal = 32.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                elevation = 8.dp,
                backgroundColor = Color.White
            ) {
                Column(modifier = Modifier.padding(32.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nom Prénom",
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue,
                            modifier = Modifier.padding(bottom = 8.dp),

                            )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = "Adresse",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = "Numéro de téléphone",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = "Adresse e-mail",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = "Staut matrimonial",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                        }
                    }

                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    SectionTitle(title = "Expérience professionnelle")

                    ExperiencePro3()

                    SectionTitle(title = "Compétences professionnelles")

                    Competences3()

                    SectionTitle(title = "Formation")

                    Formation3()

                    SectionTitle(title = "Langues")

                    Langues3()

                    SectionTitle(title = "Centres d'intérêt")

                    CentresInteret3()

                    SectionTitle(title = "Projets personnels")

                    ProjetsPersonnels3()
                }
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "OK")
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = title.toUpperCase(),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
    }
}

@Composable
fun ExperiencePro3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Nom de l'entreprise", fontWeight = FontWeight.Bold)
        Text(text = "Poste occupé, Dates de début et de fin")
        Text(text = "Missions effectuées :", fontWeight = FontWeight.Bold)
        Text(text = "- Mission 1")
        Text(text = "- Mission 2")
// Ajoutez d'autres éléments en fonction de vos expériences
    }
}

//Formation :
@Composable
fun Formation3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Nom du diplôme obtenu", fontWeight = FontWeight.Bold)
        Text(text = "Nom de l'établissement, Dates de début et de fin")
        Text(text = "Matieres étudiées :", fontWeight = FontWeight.Bold)
        Text(text = "- Matiere 1")
        Text(text = "- Matiere 2")
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

//Compétences :
@Composable
fun Competences3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Compétences techniques :", fontWeight = FontWeight.Bold)
        Text(text = "- Compétence 1")
        Text(text = "- Compétence 2")
        Text(text = "Logiciels maîtrisés :", fontWeight = FontWeight.Bold)
        Text(text = "- Logiciel 1")
        Text(text = "- Logiciel 2")
// Ajoutez d'autres éléments en fonction de vos compétences
    }
}

//Langues :
@Composable
fun Langues3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text ="Langues étrangères :", fontWeight = FontWeight.Bold)
        Text(text = "- Langue 1 : Niveau de maîtrise")
        Text(text = "- Langue 2 : Niveau de maîtrise")
        Text(text = "Certifications obtenues :", fontWeight = FontWeight.Bold)
        Text(text = "- Certification 1")
        Text(text = "- Certification 2")
// Ajoutez d'autres éléments en fonction de vos compétences linguistiques
    }
}

//Centres d'intérêt :
@Composable
fun CentresInteret3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Activités pratiquées :", fontWeight = FontWeight.Bold)
        Text(text = "- Activité 1")
        Text(text = "- Activité 2")
        Text(text = "Bénévolat :", fontWeight = FontWeight.Bold)
        Text(text = "- Association 1")
        Text(text = "- Association 2")
// Ajoutez d'autres éléments en fonction de vos centres d'intérêt
    }
}

//Projets personnels :
@Composable
fun ProjetsPersonnels3() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Projets personnels :", fontWeight = FontWeight.Bold)
        Text(text = "- Projet 1")
        Text(text = "- Projet 2")
        Text(text = "Contributions à des projets communautaires :", fontWeight = FontWeight.Bold)
        Text(text = "- Projet communautaire 1")
        Text(text = "- Projet communautaire 2")
// Ajoutez d'autres éléments en fonction de vos projets personnels
    }
}

