package eu.tutorials.myrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import eu.tutorials.myrecipeapp.View.RecipeApp
import eu.tutorials.myrecipeapp.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
                    RecipeApp(navController)
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

