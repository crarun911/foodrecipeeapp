package com.dcoders.recipeapp

data class Category(
    val idCategory:Int,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String
)

data class CategoryListResponse(val categories:List<Category> )