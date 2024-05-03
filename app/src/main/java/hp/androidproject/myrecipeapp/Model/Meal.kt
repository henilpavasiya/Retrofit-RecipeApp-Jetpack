package hp.androidproject.myrecipeapp.Model

data class Meal(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String,
    val strType: String
)

data class MealsResponse(val meals: List<Meal>)
