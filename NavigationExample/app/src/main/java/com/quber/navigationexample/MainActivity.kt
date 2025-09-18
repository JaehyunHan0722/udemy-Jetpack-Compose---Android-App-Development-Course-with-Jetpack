package com.quber.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quber.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationExampleTheme {
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "MainPage",
    ) {
        composable(route = "MainPage") { MainPage(navController) }
        composable(
            route = "SecondPage/{name}/{age}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            val age = navBackStackEntry.arguments?.getInt("age")

            name?.let {
                age?.let {
                    SecondPage(navController, name, age)
                }
            }
        }
        composable(route = "popBackStack") { navController.popBackStack() }
    }
}

