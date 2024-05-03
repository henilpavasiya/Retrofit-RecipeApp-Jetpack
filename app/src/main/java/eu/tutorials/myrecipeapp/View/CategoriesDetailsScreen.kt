package eu.tutorials.myrecipeapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import eu.tutorials.myrecipeapp.Model.Category
import eu.tutorials.myrecipeapp.R

import eu.tutorials.myrecipeapp.R.drawable.*
import eu.tutorials.myrecipeapp.ViewModel.MainViewModel

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