package com.example.bettercvapp.ModeleGenerer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bettercvapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewUserModel(navController: NavController){

    Surface(
        //color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(R.drawable.profile_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(98.dp)
                        .padding(end = 16.dp),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        "Yvan Njopmo",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold
                    )
                    Text("UI/UX Designer")

                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text("yvannjopmo85@gmail.com")
                    }

                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_phone_48px),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text("698-023-896")
                    }

                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_marker_48px),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text("Douala, Cameroun")
                    }

                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Box {
                Text(
                    text = "Designer graphique créatif avec plus de 5 ans d'expérience dans la conception de supports de communication visuelle pour des marques de renom."
                )
            }



            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                contentPadding = PaddingValues(bottom = 40.dp)
            ) {
                stickyHeader {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Langues",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }

                    Row() {

                        Text(text = "Français")
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .width(80.dp)
                                .height(5.dp)
                                .background(Color.Blue)
                        ) {

                        }
                        Text(text = "80%")

                    }
                    Row() {

                        Text(text = "Anglais")
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .width(50.dp)
                                .height(5.dp)
                                .background(Color.Blue)
                        ) {

                        }
                        Text(text = "50%")

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Compétences",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(
                            "Maîtrise des logiciels de conception graphique tels que Adobe Photoshop," +
                                    " Illustrator, InDesign, Sketch, Figma, etc."
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(
                            "Connaissance approfondie des principes de conception" +
                                    " d'interfaces utilisateur (UI) et d'expériences utilisateur (UX)"
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Formations",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Certificat en conception d'interfaces utilisateur, Interaction Design Foundation, 2022")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Diplôme en design graphique obtenue à  l'École de design XYZ, 2020")
                    }


                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Experience Professionnelle",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Designer graphique, XYZ Agency, 2018 - présent")
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Conception de sites web, d'identités visuelles, de supports de marketing imprimés et numériques")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Collaboration avec des équipes internes et externes pour assurer la qualité et la cohérence des projets")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Designer graphique, ABC Studio, 2016 - 2018")
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Conception de supports de communication pour des marques locales et nationales")
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Text(" Création d'identités visuelles, de supports imprimés et numériques")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Hobbies",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {

                        Text(" Sports")
                        Text(" Lecture")
                        Text(" Voyages")
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Gray)
                            .fillMaxWidth()
                            .width(120.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Reseaux sociaux",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_facebook_48px),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )

                        Text(" Yvan Nguewo")

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_instagram_logo_48px),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )

                        Text(" Yvan Nguewo")

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.icons8_full_stop_24px_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_github_32px),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 8.dp)
                        )

                        Text(" Yvan-Nguewo")

                    }

                    Button(
                        onClick = { /*TODO*/ },
                        Modifier
                            .height(40.dp)
                            .width(115.dp)
                            .align(Alignment.CenterHorizontally),

                        ) {
                        Text(text = "Enregister votre Cv")
                    }

                }

            }
        }
    }
}