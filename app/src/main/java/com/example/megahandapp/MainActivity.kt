package com.example.megahandapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.megahandapp.ui.theme.MegahandAppTheme
import com.example.megahandapp.ui.theme.NewScreenTopBar
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MegahandAppTheme {
//                    LoadingScreen()
                MegaHand()
//                CenterMain(
//                    onClick = {}
//                )
            }
        }
    }
}


@Composable
fun MegaHand()
{
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            NavHostContainerTopBar(
                navController = navController
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)) {}
    }
}

@Composable
fun NavHostContainerTopBar(
    navController: NavHostController,
){
    NavHost(
        modifier = Modifier
            .padding(0.dp, 54.dp),
        navController = navController,
        startDestination = "Главная",
    ){
        composable("Главная") {
            MainTopBar(
                nameCategory = "Главная",
                money = "7200₽",
                onClick = {}
            )
        }
        composable("Моя карта"){
            MyCardTopBar(
                nameCategory = "Моя карта",
                money = "7200₽",
                onClick = {}
            )
        }
        composable("Магазины") {
            ShopTopBar(
                nameCategory = "Магазины",
                money = "7200₽",
                onClick = {}
            )
        }
        composable("Профиль") {
            ShopTopBar(
                nameCategory = "Профиль",
                money = "7200₽",
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun MegaHandPreview(){
    MegaHand()
}

@Composable
fun BottomBar(
    navController: NavHostController,
) {

    BottomNavigation(
        backgroundColor = (Color.White),
        elevation = 10.dp,
        modifier = Modifier
            .padding(bottom = 50.dp)
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        BottomNavigationItem(
            selected = currentRoute == "Главный",
            onClick = { navController.navigate("Главный") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.home),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Главный",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            },
            alwaysShowLabel = true
        )

        BottomNavigationItem(
            selected = currentRoute == "Моя карта",
            onClick = { navController.navigate("Моя карта") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.card),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Моя карта",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            selected = currentRoute == "Магазины",
            onClick = { navController.navigate("Магазины") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.shop),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Магазины",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            selected = currentRoute == "Профиль",
            onClick = { navController.navigate("Профиль") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.account),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Профиль",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            selected = currentRoute == "",
            onClick = {  },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.other),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Другое",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            },
            alwaysShowLabel = false
        )
    }
}
