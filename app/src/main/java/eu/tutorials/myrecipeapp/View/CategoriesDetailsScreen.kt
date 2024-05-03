package eu.tutorials.myrecipeapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import eu.tutorials.myrecipeapp.Model.Category

@Composable
fun CategoriesDetailsScreen(category: Category) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = category.strCategory, fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "Item Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CategoriesDetailsScreenPreview() {
//    CategoriesDetailsScreen()
}