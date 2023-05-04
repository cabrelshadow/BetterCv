package com.example.bettercvapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bettercvapp.R
import com.example.bettercvapp.R.*
import com.example.bettercvapp.ui.theme.Gray
import com.example.bettercvapp.ui.theme.Poppins
@Composable
fun HomeScreen(navController: NavController) {
    TopBarApp()
    Text(text = "Cv Template",
        fontFamily = Poppins,
        modifier = Modifier.padding(vertical = 100.dp, horizontal = 30.dp)
    )
    CardList1()
    Box(modifier = Modifier.fillMaxWidth()){
        RoundedCardList()
    }

    BottomNavigation(navController)
}


@Composable
fun TopBarApp(

) {
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(32.dp)
                    .background(color = Gray, CircleShape)

            ) {
                Image(
                    painter = painterResource(id = drawable.m1),
                    contentDescription ="photo",

                    modifier = Modifier.height(50.dp)

                )
            }
        }
    }
}



val cardData = listOf(
    CardData(drawable.ko, "Design cv"),
    CardData(drawable.ko, "Developer "),
    CardData(drawable.ko, "Data annalist 3"),
    CardData(drawable.ko, "Big data"),
    CardData(drawable.ko, "Scrum master"),
    CardData(drawable.ko, "Infographic"),
)
@Composable
fun CardList1() {


    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 150.dp, horizontal = 10.dp)
    ) {
        items(cardData.size) { index ->
            Card(
                cardData[index],
                Modifier.width(150.dp),
                RoundedCornerShape(20.dp)
            )
        }
    }
}

data class CardData(val image: Int, val description: String)

@Composable
fun Card(cardData: CardData, modifier: Modifier, shape: Shape) {
    Box(
        modifier = modifier
            .background(Color.White, shape)
            .clickable {/* Gérer le clic de la carte ici */}
    ) {
        Image(
            painter = painterResource(id = cardData.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        Text(
            text = cardData.description,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
        )
    }
}
@Composable
fun BottomNavigation(
    navController: NavController,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    val navItems = listOf(
        BottomNavItem.Home,
       // BottomNavItem.Profile,
        BottomNavItem.Favorites,
        )
    val selectedIndex = remember { mutableStateOf(1) }

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp),
        ) {
        navItems.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, null) },
                label = { Text(item.title) },
                selected = selectedIndex.value == index,
                /*onClick = {
                    navController.navigate("HomeScreen"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    },*/
                onClick = { selectedIndex.value = index },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray
            )
        }
        Button(onClick = { navController.navigate("ProfileScreen"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true } },
                Modifier.height(55.dp)
        ) {
            Icon(Icons.Rounded.AddCircle, contentDescription = "")
            Text(text = "Creer un Cv")

        }
    }
}

sealed class BottomNavItem(
    val icon: ImageVector,
    val title: String
) {
    object Home : BottomNavItem(Icons.Filled.Home, "Home")
    /*object Profile : BottomNavItem(Icons.Filled.AddCircle, "Creer un cv")*/
    object Favorites : BottomNavItem(Icons.Filled.Favorite, "Favorites")

}



@Composable
fun RoundedCardList() {
    Box(modifier = Modifier.fillMaxHeight()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 300.dp),
        ) {
            for (i in 1..2) {
                RoundedCard(
                    modifier = Modifier.fillMaxWidth(),
                    imageResId = R.drawable.ko,
                    title = "Titre de la carte $i",
                    description = "Description de la carte $i"
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,

    imageResId: Int,
    title: String,
    description: String
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}