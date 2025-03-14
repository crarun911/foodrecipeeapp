package com.dcoders.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val mainActivityViewModel:MainActivityViewModel= viewModel()
    val categoryState by mainActivityViewModel.categoryState

    NavHost(navController = navController, startDestination = Screen.CategoryListScreen.route ){
        composable(route=Screen.CategoryListScreen.route){
            CateogyListScreen(categoryState = categoryState,navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("categoryItem",it)
                navController.navigate(Screen.CategoryDetailScreen.route)
            })
        }
        composable(route=Screen.CategoryDetailScreen.route) {
            val category=navController.previousBackStackEntry?.savedStateHandle?.get<Category>(
                "categoryItem"
            )?: Category(0,"","","")
            
            CategoryDetailScreen(category = category)
        }
    }

}