package eu.tutorials.myrecipeapp.View

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.myrecipeapp.Model.Category
import eu.tutorials.myrecipeapp.Screen
import eu.tutorials.myrecipeapp.ViewModel.MainViewModel

@Composable
fun RecipeApp(navController: NavHostController){

    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route){
            RecipeScreen(viewstate=viewstate, navigateToSecondScreen = {
              // This part is responsible for passing data from current screen to details screen
                // It utilizes the savedStateHandle, which component of the Compose navigation framework.
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate (Screen. DetailScreen.route)
            })
        }
        composable(Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoriesDetailsScreen(category = category)
        }
    }
}