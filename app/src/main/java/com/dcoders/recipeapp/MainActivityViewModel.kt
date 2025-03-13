package com.dcoders.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {
    init {
        getCategoryState()
    }
    private val _categoryState=mutableStateOf(CategoryState())
    val categoryState:State<CategoryState> =_categoryState
    fun getCategoryState(){

        viewModelScope.launch {
                try {
                    val response= recipeService.getCategories()
                    _categoryState.value=_categoryState.value.copy(
                        catgeoryList = response.categories,loading = false,
                        error = null

                    )

                }
                catch (exception:Exception ){
                    _categoryState.value=_categoryState.value.copy(
                        loading = false,
                        error("error fetching categories ${exception.message}")
                    )

                }



        }



    }



    data class CategoryState(
        val loading:Boolean=true,
        val catgeoryList:List<Category> = emptyList(),
        val error:String?=null
    )





}