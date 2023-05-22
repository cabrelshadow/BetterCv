package com.example.bettercvapp.ModeleGenerer

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bettercvapp.showdata.DataViewModel
import com.example.bettercvapp.showdata.Recommendation

@Composable
fun NewCvScreen3(navController: NavController,
                 dataViewModel: DataViewModel = viewModel()
                 ) {
    val getData = dataViewModel.state.value
    val getData1 = dataViewModel.state1.value
    val getData2 = dataViewModel.state2.value
    val getData3 = dataViewModel.state3.value
    val getData4 = dataViewModel.state4.value
    val getData5 = dataViewModel.state5.value
    val getData6 = dataViewModel.state6.value
    val getData7 = dataViewModel.state7.value

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
                            text = getData.firstname+" "+getData.lastname,
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue,
                            modifier = Modifier.padding(bottom = 8.dp),

                            )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = "Address: "+getData7.city,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = getData5.Email+" \n"+getData5.Phone,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = getData.borndate,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = "Staut matrimonial: "+getData.maritalstatus,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black
                            )
                            Text(
                                text = "Permis de conduire: "+getData.drivinglicence,
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

                    ExperiencePro3(getData1.organisation,getData1.function,getData1.startDate,getData1.endDate)

                    SectionTitle(title = "Compétences professionnelles")

                    Competences3(getData6.competence,getData6.level)

                    SectionTitle(title = "Formation")

                    Formation3(getData2.diploma,getData2.school,getData2.startdate,getData2.enddate,getData2.domainOfStudy,getData2.obtainresult)

                    SectionTitle(title = "Langues")

                    Langues3(getData7.language,getData7.level)

                    SectionTitle(title = "Centres d'intérêt")

                    CentresInteret3()

                    SectionTitle(title = "Projets personnels")

                    ProjetsPersonnels3(getData3.NameProject,getData3.Status,getData3.Partner,getData3.UrlProject,getData3.DescriptionOfProject,getData3.StartDate,getData3.StartDate)

                    SectionTitle(title = "Recommandation")

                    Recommandation(getData4.PersonName,getData4.ResearchPost,getData4.Number)
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
fun ExperiencePro3(nameets:String, post:String, dtdeb:String, datfin:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "$nameets", fontWeight = FontWeight.Bold)
        Text(text = "Poste occupé: $post,\n Date debut-fin: $dtdeb - $datfin")
        Text(text = "Missions effectuées:", fontWeight = FontWeight.Bold)
        Text(text = "Mission 1")
        Text(text = "Mission 2")
// Ajoutez d'autres éléments en fonction de vos expériences
    }
}

//Formation :
@Composable
fun Formation3(dip:String,school:String,Start:String,end:String,filiere:String,obtainresult:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Diplôme obtenu: $dip", fontWeight = FontWeight.Bold)
        Text(text = "Nom de l'établissement: $school" + "\nDates debut $Start Dates fin $end")
        Text(text = "Specialite:$filiere", fontWeight = FontWeight.Bold)
        Text(text = "Mention:$obtainresult", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

//Compétences :
@Composable
fun Competences3(comp:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Compétences techniques:", fontWeight = FontWeight.Bold)
        Text(text = "Compétence: $comp")
        Text(text = "Niveau: $niv")
// Ajoutez d'autres éléments en fonction de vos compétences
    }
}

//Langues :
@Composable
fun Langues3(lang:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues étrangères :", fontWeight = FontWeight.Bold)
        Text(text = "Langue: $lang \nNiveau: $niv")
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
        Text(text = "Activité 1")
        Text(text = "Activité 2")
        Text(text = "Bénévolat :", fontWeight = FontWeight.Bold)
        Text(text = "Association 1")
        Text(text = "Association 2")
// Ajoutez d'autres éléments en fonction de vos centres d'intérêt
    }
}

//Projets personnels :
@Composable
fun ProjetsPersonnels3(NameProject:String,Status: String,Partner: String
    ,UrlProject: String,DescriptionOfProject: String,StartDate: String,enddate: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Projets personnels: $NameProject", fontWeight = FontWeight.Bold)
        Text(text = "Staut: $Status")
        Text(text = "Contrubiteur(s): $Partner", fontWeight = FontWeight.Bold)
        Text(text = "URL: $UrlProject")
        Text(text = "Description: $DescriptionOfProject")
        Text(text = "Date: $StartDate**$enddate")
// Ajoutez d'autres éléments en fonction de vos projets personnels
    }
}

@Composable
fun Recommandation(PersonName:String,ResearchPost:String,Number:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Nom: $PersonName ", fontWeight = FontWeight.Bold)
        Text(text = "Poste: $ResearchPost")
        Text(text = "Numero de telephone: $Number")
// Ajoutez d'autres éléments en fonction de vos compétences linguistiques
    }
}

