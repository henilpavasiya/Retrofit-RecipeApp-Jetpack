package eu.tutorials.myrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import eu.tutorials.myrecipeapp.Model.Category
import eu.tutorials.myrecipeapp.View.CategoriesDetailsScreen
import eu.tutorials.myrecipeapp.View.RecipeApp
import eu.tutorials.myrecipeapp.View.RecipeScreen
import eu.tutorials.myrecipeapp.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyRecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeApp(navController)
                }
            }
        }
    }
}

//@Composable
//fun MyApp(){
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "recipeFirstScreen") {
//        composable("recipeFirstScreen"){
//            RecipeScreen{category->
//                navController.navigate("categoriesDetailsScreen/${category}")
//            }
//        }
//        composable("categoriesDetailsScreen/{category}") {
//            val category = it.arguments?.get("category") ?: "no name"
//            CategoriesDetailsScreen(category as Category)
//        }
//    }
//
//}

