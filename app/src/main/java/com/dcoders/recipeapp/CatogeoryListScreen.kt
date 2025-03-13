package com.dcoders.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter


@Composable
fun CateogyListScreen(modifier: Modifier=Modifier){
    val mainActivityViewModel:MainActivityViewModel= viewModel()
    val categoryState by mainActivityViewModel.categoryState

    Box (modifier=modifier.fillMaxSize()){
        when{
            categoryState.loading->{
                CircularProgressIndicator(modifier=Modifier.align(Alignment.Center))
            }
            categoryState.error!=null->{
                Text(text = "Error occured")
            }
            else ->{
                CategoryListOfItems(categoryState.catgeoryList)
            }
        }

    }
}
@Composable
fun CategoryListOfItems(categoryList:List<Category>){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize() ){
            items(categoryList){category->
                CategoryItem(categoryItem = category)
            }
    }
}
@Composable
fun CategoryItem(categoryItem:Category){
    Column {
        Image(painter = rememberAsyncImagePainter(categoryItem.strCategoryThumb),
            contentDescription =null,
            modifier=Modifier.aspectRatio(1f)
        )
        Text(text = categoryItem.strCategory,
            color = Color.Black,
            modifier = Modifier.padding(top=4.dp)

        )
    }
}