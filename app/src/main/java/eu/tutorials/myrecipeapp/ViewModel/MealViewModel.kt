package eu.tutorials.myrecipeapp.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.myrecipeapp.Model.Category
import eu.tutorials.myrecipeapp.Model.Meal
import eu.tutorials.myrecipeapp.recipeService
import kotlinx.coroutines.launch
import java.lang.Exception

class MealViewModel : ViewModel() {

    private val _mealsState = mutableStateOf(RecipeState())
    val mealsState: State<RecipeState> = _mealsState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getMeals()
                _mealsState.value = _mealsState.value.copy(
                    list = response.meals,
                    loading = false,
                    error = null
                )

            }catch (e: Exception){
                _mealsState.value = _mealsState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Meal> = emptyList(),
        val error: String? = null
    )

}