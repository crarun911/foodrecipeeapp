package com.dcoders.recipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory:Int,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String
):Parcelable

data class CategoryListResponse(val categories:List<Category> )