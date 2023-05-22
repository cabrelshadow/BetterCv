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

@Composable
fun NewCvScreen2(navController: NavController,
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
            title = { Text(text = "Cv Infographe") },
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
                        text = getData.firstname+" "+getData.lastname,
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue, // bleu
                        modifier = Modifier.padding(bottom = 8.dp),

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
                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    SectionTitle2(title = "Expérience professionnelle")

                    ExperiencePro(getData1.organisation,getData1.function,getData1.startDate,getData1.endDate)

                    SectionTitle2(title = "Compétences Professionnels")

                    Competences(getData6.competence,getData6.level)

                    SectionTitle2(title = "Formation")

                    Formation(getData2.diploma,getData2.school,getData2.startdate,getData2.enddate,getData2.domainOfStudy,getData2.obtainresult)

                    SectionTitle2(title = "Langues")

                    Langues(getData7.language,getData7.level)

                    SectionTitle2(title = "Centres d'intérêt")

                    CentresInteret()

                    SectionTitle2(title = "Projets personnels")

                    ProjetsPersonnels(getData3.NameProject,getData3.EndDate,getData3.StartDate)
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
fun ExperiencePro(nameets:String, post:String, dtdeb:String, datfin:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "$nameets", fontWeight = FontWeight.Bold)
        Text(text = "Poste occupé: $post,\n Date debut-fin: $dtdeb - $datfin")
        Text(text = "Missions effectuées :", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de vos expériences
    }
}

//Formation :
@Composable
fun Formation(dip:String,school:String,Start:String,end:String,filiere:String,obtainresult:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Diplôme obtenu: $dip", fontWeight = FontWeight.Bold)
        Text(text = "Nom de l'établissement: $school" +  "\nDates debut-fin $Start - $end")
        Text(text = "Specialite:$filiere", fontWeight = FontWeight.Bold)
        Text(text = "Mention:$obtainresult", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

//Compétences :
@Composable
fun Competences(comp:String,niv:String) {
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
fun Langues(lang:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues:", fontWeight = FontWeight.Bold)
        Text(text = "Langue: $lang \n-Niveau: $niv")
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
fun ProjetsPersonnels(projet:String,datfin: String,dtdeb: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Projets personnels: $projet", fontWeight = FontWeight.Bold)
        Text(text = "Date debut: $dtdeb")
        Text(text = "Date fin: $datfin")
// Ajoutez d'autres éléments en fonction de vos projets personnels
    }
}
