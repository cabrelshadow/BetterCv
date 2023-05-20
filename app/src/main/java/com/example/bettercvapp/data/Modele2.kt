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
fun CvScreen2(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Cv Infographic") },
            navigationIcon = {
                IconButton(onClick ={
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
                .padding(16.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                elevation = 4.dp,
                backgroundColor = Color(0xFFF7F5E6) // beige clair
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Marc Luc PORREAU ",
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue, // bleu
                        modifier = Modifier.padding(bottom = 8.dp),

                        )
                    Text(
                        text = "27Ac avenue, douala",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "698954875",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "marc@gmail.com",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    SectionTitle2(title = "Expérience professionnelle")

                    ExperiencePro()

                    SectionTitle2(title = "Compétences Professionnels")

                    Competences()

                    SectionTitle2(title = "Formation")

                    Formation()

                    SectionTitle2(title = "Langues")

                    Langues()

                    SectionTitle2(title = "Centres d'intérêt")

                    CentresInteret()

                    SectionTitle2(title = "Projets personnels")

                    ProjetsPersonnels()
                }
            }
        }

        Button(
            onClick = {
                navController.navigate("NewCvScreen2"){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Appliquer ce Model")
        }
    }
}

@Composable
fun SectionTitle2(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = Color.Blue, // bleu
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = title.toUpperCase(),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = Color.Blue, // bleu
        )
    }
}


@Composable
fun ExperiencePro() {
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
fun Formation() {
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
fun Competences() {
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
fun Langues() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues étrangères :", fontWeight = FontWeight.Bold)
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
fun CentresInteret() {
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
fun ProjetsPersonnels() {
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
