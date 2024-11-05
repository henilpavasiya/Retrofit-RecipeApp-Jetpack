package eu.tutorials.myrecipeapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import eu.tutorials.myrecipeapp.Model.Category
import eu.tutorials.myrecipeapp.Model.Meal
import eu.tutorials.myrecipeapp.ViewModel.MainViewModel
import eu.tutorials.myrecipeapp.ViewModel.MealViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate: MainViewModel.RecipeState,
                 navigateToSecondScreen: (Category) -> Unit) {

    MaterialTheme {
        Scaffold(topBar = {
                TopAppBar(
                    {
                        Text(text = "Recipe App", fontSize = 20.sp)
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFFD7F58),  // Sets the background color
                        titleContentColor = Color.White  // Sets the title text color
                    ),
                    actions = {
                        // Add your top app bar actions here (e.g., an IconButton)
                        IconButton(onClick = { /* Handle action here */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                 contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                    }
                )
            }, content = { _ ->
                // The main content of your app


                val mealViewModel: MealViewModel = viewModel()
                val viewmealstate by mealViewModel.mealsState

                Box(modifier = Modifier.fillMaxSize()) {

                    when {
                        viewstate.loading || viewmealstate.loading -> {
                            CircularProgressIndicator(modifier.align(Alignment.Center))
                        }

                        viewstate.error != null || viewmealstate.error != null -> {
                            Text("ERROR OCCURRED")
                        }

                        else -> {
                            CategoryScreen(
                                categories = viewstate.list,
                                meals = viewmealstate.list,
                                navigateToSecondScreen
                            )
                        }
                    }
                }
            })
    }



}

@Composable
fun CategoryScreen(
    categories: List<Category>,
    meals: List<Meal>,
    navigateToSecondScreen: (Category) -> Unit
) {

    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryItem(category = category, meals = meals, navigateToSecondScreen)
        }
    }
}


// How each Items looks like
@Composable
fun CategoryItem(
    category: Category,
    meals: List<Meal>,
    navigateToSecondScreen: (Category) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                navigateToSecondScreen(category)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
            )
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = category.strCategory,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )
            // Optimized Ingredient Matching & Text Display
            val matchingIngredients =
                meals.filter { meal -> // It iterates through each item (meal) in the meals list.
                    category.strCategory.lowercase() == meal.strIngredient.lowercase()
                }

            if (matchingIngredients.isNotEmpty()) {
                val ingredientText = buildString {
                    matchingIngredients.forEachIndexed { index, meal ->
                        append(meal.idIngredient)
                        if (index < matchingIngredients.lastIndex) {
                            append(", ") // Add comma and space for multiple ingredients
                        }
                    }
                }
                Text(
                    text = " (Ingredient IDs: $ingredientText)",
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }

    }
}



