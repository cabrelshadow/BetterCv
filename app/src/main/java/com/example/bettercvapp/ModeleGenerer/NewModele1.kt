package com.example.bettercvapp.ModeleGenerer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bettercvapp.showdata.DataViewModel

@Composable
fun NewCvScreen(navController:NavController,
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
            title = { Text(text = "Cv Developer") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate("ModelScreen"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true }
                }) {
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
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = getData.firstname+" "+getData.lastname,
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Address: "+getData7.city,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Num telephone: "+getData5.Phone,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Address e-mail: "+getData5.Email,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    NewSectionTitle(title = "Expérience professionnelle")

                    NewExperiencePro(getData1.organisation,getData1.function,getData1.startDate,getData1.endDate)

                    NewSectionTitle(title = " Compétences Professionnels")

                    NewCompetences(getData6.competence,getData6.level)

                    NewSectionTitle(title = "Formation")

                    NewFormation(getData2.diploma,getData2.school,getData2.startdate,getData2.enddate,getData2.domainOfStudy)

                    NewSectionTitle(title = "Langues")

                    NewLangues(getData7.language,getData7.level)

                   // NewSectionTitle(title = "Centres d'intérêt")

                    //NewCentresInteret()

                    NewSectionTitle(title = "Projets personnels")

                    NewProjetsPersonnels(getData3.NameProject,getData3.EndDate,getData3.StartDate)
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
fun NewSectionTitle(title: String) {
    Text(
        text = title.toUpperCase(),
        style = MaterialTheme.typography.subtitle2,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp, top = 24.dp)
    )
}


@Composable
fun NewExperiencePro(nameets : String,post:String,dtdeb:String,datfin:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Entreprise $nameets", fontWeight = FontWeight.Bold)
        Text(text = "Poste occupé: $post,\n Date debut-fin: $dtdeb - $datfin")
        Text(text = "Missions effectuées:", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de vos expériences
    }
}

//Formation :
@Composable
fun NewFormation(dip:String,school:String,Start:String,end:String,filiere:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "diplôme obtenu: $dip", fontWeight = FontWeight.Bold)
        Text(text = "Nom de l'établissement: $school" +
                "\nDates debut-fin $Start - $end")
        Text(text = "Specialite: $filiere", fontWeight = FontWeight.Bold)
// Ajoutez d'autres éléments en fonction de votre formation
    }
}

//Compétences :
@Composable
fun NewCompetences(comp:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Compétences techniques :", fontWeight = FontWeight.Bold)
        Text(text = "Compétence: $comp")
        Text(text = "Niveau: $niv")
        /*Text(text = "Logiciels maîtrisés :", fontWeight = FontWeight.Bold)
        Text(text = "- Logiciel 1 - RAS")
        Text(text = "- Logiciel 2 - RAS")*/
// Ajoutez d'autres éléments en fonction de vos compétences
    }
}

//Langues :
@Composable
fun NewLangues(lang:String,niv:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Langues:", fontWeight = FontWeight.Bold)
        Text(text = "- Langue: $lang \n-Niveau: $niv")
// Ajoutez d'autres éléments en fonction de vos compétences linguistiques
    }
}

//Centres d'intérêt :
@Composable
fun NewCentresInteret() {
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
fun NewProjetsPersonnels(projet:String,datfin: String,dtdeb: String,) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Projets: $projet", fontWeight = FontWeight.Bold)
        Text(text = "Date debut: $dtdeb")
        Text(text = "Date fin: $datfin")
        /*Text(text = "Contributions à des projets communautaires :", fontWeight = FontWeight.Bold)
        Text(text = "- Projet communautaire 1")
        Text(text = "- Projet communautaire 2")*/
// Ajoutez d'autres éléments en fonction de vos projets personnels
    }
}