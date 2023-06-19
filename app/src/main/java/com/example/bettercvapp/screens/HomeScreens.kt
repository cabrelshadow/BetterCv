package com.example.bettercvapp.screens

import CvScreen
import android.media.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bettercvapp.R
import com.example.bettercvapp.ui.theme.Gray
import com.example.bettercvapp.ui.theme.Poppins



data class MyData(val title:String, val description:String,val Route:String)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreens(navController: NavController) {


    var mydata by remember {mutableStateOf(MyData("Curriculum vitae", "Developer", "NewCvScreen"))}
    var showCard by remember { mutableStateOf(true) }
    Scaffold(
        bottomBar = {BottomNavigation(navController)},
        content = {it
            LazyColumn(){
                stickyHeader {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)){
                        Row(modifier = Modifier.padding(5.dp)) {
                            TopBarApp()
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)){
                        Row(modifier = Modifier.padding(5.dp)) {
                            Text(text = "Cv Template",
                                fontFamily = Poppins,
                                modifier = Modifier.offset(18.dp,10.dp)
                            )
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)){
                        Row(modifier = Modifier.padding(0.dp)) {
                            ScrollableImage()
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)){
                        Row(modifier = Modifier.padding(3.dp)) {
                            Text(text = "Your CV", fontFamily = Poppins,
                                modifier = Modifier.offset(18.dp,0.dp))
                        }
                    }
                }
                items(1) {

                    if (showCard){
                        RoundedCard(titre = mydata.title , Description =  mydata.description,
                            painter = painterResource(id = R.drawable.infographe), Route = mydata.Route,navController)
                    }

                }
                item { Spacer(modifier = Modifier.height(80.dp)) }
            }
        }
    )

    Box(Modifier.background(color = Color.White)) {
    }
}

val imagesList = listOf(
    R.drawable.devellopeur,
    R.drawable.analyste,
    R.drawable.designer,
    R.drawable.infographe
)
val textList = listOf(
    "Developer", "Designer", "Analyst", "Designer"
)

@Composable
fun TopBarApp() {
    Surface(
        color = Gray,
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 28.dp, start = 16.dp, end = 16.dp)
            .height(48.dp)
            .fillMaxWidth()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "BetterCv",
                textAlign = TextAlign.Left,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun ScrollableImage(){
    val images: List<Int>
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ){
        for(i in imagesList.indices){
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = imagesList[i]),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(0.dp, (-10).dp)
                        .size(145.dp)
                )
                for (b in textList.indices) {
                    Text(
                        text = textList[i],
                        modifier = Modifier
                            .offset(38.dp, 120.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}








@Composable
fun BottomNavigation(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Deconnection(navController)
        Model(navController)
        create(navController)
        edit(navController)
    }
}


@Composable
fun create(navController: NavController){
    Row(Modifier.offset()) {
        Button(onClick = { navController.navigate("MenuForm"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } },
            Modifier.height(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(Icons.Rounded.AddCircle, contentDescription = "", tint = Color.Blue)
            Text(text = "Add Info")
        }
    }
}


@Composable
fun edit(navController: NavController){
    Row(Modifier.offset()) {
        Button(onClick = { navController.navigate("UPMenuForm"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } },
            Modifier.height(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(Icons.Rounded.Edit, contentDescription = "", tint = Color.Blue)
        }
    }
}



@Composable
fun Model(navController: NavController){
    Row(Modifier.offset()) {
        Button(onClick = { navController.navigate("ModelScreen"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } },
            Modifier.height(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(Icons.Rounded.List, contentDescription = "", tint = Color.Blue)
            Text(text = "Model")
        }
    }
}

@Composable
fun Deconnection(navController: NavController){
    Row(Modifier.offset()) {
        Button(onClick = { navController.navigate("LoginScreen"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } },
            Modifier.height(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Icon(Icons.Rounded.ExitToApp, contentDescription = "", tint = Color.Blue)
        }
    }
}

@Composable
fun RoundedCard(titre : String,
                Description : String,
                painter : Painter,
                Route: String,
                navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("$Route") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "$titre",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$Description",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}