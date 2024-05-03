package hp.androidproject.myrecipeapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import hp.androidproject.myrecipeapp.Model.Category

@Composable
fun CategoriesDetailsScreen(category: Category) {

    Column {
        Text(text = category.strCategory)
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "Item Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
            Text(text = category.strCategoryDescription, textAlign = TextAlign.Justify, modifier = Modifier.verticalScroll(
                rememberScrollState()))
    }
}



@Preview(showBackground = true)
@Composable
fun CategoriesDetailsScreenPreview() {
//    CategoriesDetailsScreen()
}