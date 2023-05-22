package com.example.bettercvapp.ModeleGenerer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bettercvapp.showdata.DataViewModel

@Composable
fun NewCvScreen4(navController: NavController,
                 dataViewModel: DataViewModel = viewModel()
                ) {
    val getData = dataViewModel.state.value
    val getData2 = dataViewModel.state2.value
    val getData3 = dataViewModel.state3.value
    val getData5 = dataViewModel.state5.value
    val getData6 = dataViewModel.state6.value
    val getData7 = dataViewModel.state7.value

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "CV junior") },
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
                            text = getData.firstname+" "+getData.lastname,
                            style = MaterialTheme.typography.h3,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 16.dp),

                            )
                        Text(
                            text = "Address: "+getData7.city,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Numero de telephone: "+getData5.Phone,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Address e-mail: "+getData5.Email,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )
                        Text(
                            text = "Ecole : "+getData2.school,
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Gray,
                            //modifier = Modifier.padding(bottom = 32.dp),
                        )

                        SectionTitle4(title = "Compétences professionnelles")

                        Competences4(getData6.competence,getData6.level)

                        SectionTitle4(title = "Formation")

                        Formation4(getData2.diploma,getData2.school,getData2.startdate,getData2.enddate,getData2.domainOfStudy,getData2.obtainresult)

                        SectionTitle4(title = "Langues")

                        Langues4(getData7.language,getData7.level)

                        SectionTitle4(title = "Projets Academiques")

                        ProjetAcademique(getData3.NameProject,getData3.Status,getData3.Partner,getData3.UrlProject,getData3.DescriptionOfProject,getData3.StartDate,getData3.StartDate)
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
            Text(text = "Telecharger ce Model")
        }
    }
}

@Composable
fun Competences4(comp:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Compétences techniques :", fontWeight = FontWeight.Bold)
        Text(text = "Compétence: $comp")
        Text(text = "Niveau: $niv")
// Ajoutez d'autres éléments en fonction de vos compétences
    }
}

@Composable
fun Formation4(dip:String,school:String,Start:String,end:String,filiere:String,obtainresult:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Diplôme obtenu: $dip", fontWeight = FontWeight.Bold)
        Text(text = "Nom de l'établissement: $school" + "\nDates debut-fin $Start - $end")
        Text(text = "Filieres Choisies:$filiere", fontWeight = FontWeight.Bold)
        Text(text = "Mention: $obtainresult", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

@Composable
fun Langues4(lang:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues étrangères:", fontWeight = FontWeight.Bold)
        Text(text = "Langue: $lang \nNiveau: $niv")
// Ajoutez d'autres éléments en fonction de vos compétences linguistiques
    }
}

@Composable
fun ProjetAcademique(NameProject:String,Status: String,Partner: String
                     ,UrlProject: String,DescriptionOfProject: String,StartDate: String,enddate: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Projets personnels: $NameProject", fontWeight = FontWeight.Bold)
        Text(text = "Staut: $Status")
        Text(text = "Contibuteur(s): $Partner", fontWeight = FontWeight.Bold)
        Text(text = "URL: $UrlProject")
        Text(text = "Description: $DescriptionOfProject")
        Text(text = "Date: $StartDate**$enddate")
    }}

@Composable
fun SectionTitle4(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}
