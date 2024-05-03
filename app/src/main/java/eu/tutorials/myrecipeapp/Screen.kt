package eu.tutorials.myrecipeapp

sealed class Screen(val route:String) {
    object RecipeScreen: Screen ("recipeScreen")
    object DetailScreen : Screen("detailScreen")
}