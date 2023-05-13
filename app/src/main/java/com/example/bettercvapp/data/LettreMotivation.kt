package com.example.bettercvapp.screens.AddScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LettreMotivationScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Lettre de Motivation") },
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
                Column(modifier = Modifier.padding(32.dp)) {
                    Text(
                        text = "Nom Prénom",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Adresse",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Téléphone / Adresse e-mail",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Objet : Candidature pour le poste de Développeur Web",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Madame, Monsieur,",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Je suis actuellement à la recherche d'un emploi en tant que Développeur Web et j'ai été très intéressé par votre offre d'emploi publiée sur votre site web. Diplômé en informatique avec une expérience de deux ans en développement web, je suis convaincu que mes compétences et mon expertise correspondent parfaitement aux exigences du poste.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Au cours de mes précédentes expériences professionnelles, j'ai travaillé sur des projets de développement web ambitieux qui m'ont permis d'acquérir une expertise approfondie en technologies web telles que HTML/CSS, JavaScript, Vue.js et Laravel. J'ai également développé des compétences en conception d'interfaces utilisateur et en gestion de bases de données MySQL.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Je suis très motivé à l'idée de rejoindre votre entreprise pour contribuer à son succès en utilisant mes compétences en développement web. J'ai hâte de discuter de ma candidature avec vous lors d'un entretien.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    Text(
                        text = "Je vous remercie pour votre considération et j'attends avec impatience votre réponse.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Cordialement,",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Nom Prénom",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black
                    )
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
