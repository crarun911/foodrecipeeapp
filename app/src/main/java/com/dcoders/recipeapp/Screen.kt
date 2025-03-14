package com.dcoders.recipeapp

sealed class Screen(val route:String){

    object CategoryListScreen:Screen(route="categorylistscreen")
    object CategoryDetailScreen:Screen(route="detailscreen")



}
