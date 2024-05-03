package eu.tutorials.myrecipeapp.View

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.myrecipeapp.Screen

@Composable
fun RecipeApp(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route){

        }
        composable(Screen.DetailScreen.route){

        }
    }
}