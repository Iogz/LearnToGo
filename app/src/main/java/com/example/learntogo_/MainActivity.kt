package com.example.learntogo_

import HomeScreen
import LocationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learntogo_.ui.theme.LearnToGo_Theme

sealed class Destination (val route: String) {
    object  Home:  Destination ("home")
    object  Account:  Destination ("account")
    object  Location:  Destination ("li")
    object  Detail:  Destination ("detail/{elementid}") {
        fun createRoute (element: Int) = "detail/$element"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnToGo_Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {

    val ctx  = LocalContext.current


    NavHost(navController = navController, startDestination = "home") {
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Account.route) { AccScreen(navController) }
        composable(Destination.Location.route) { LocationScreen(navController) }

    }
}