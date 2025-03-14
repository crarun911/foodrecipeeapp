package com.dcoders.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dcoders.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            RecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    CateogyListScreen()
//                    MyFirstNavExperiment()
                    RecipeApp(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MyFirstNavExperiment(){

     val navController= rememberNavController()
     NavHost(navController = navController, startDestination = "firstscreen" ){
         composable(route = "firstscreen"){
             var name=it.arguments?.getString("name")?:"no name"
             FirstScreen (name = name){name->
                 navController.navigate("secondscreen/$name")
             }
         }
         composable(route = "secondscreen/{name}"){
             var name=it.arguments?.getString("name")?:"no name"
             SecondScreen(name) {
                 navController.navigate("firstscreen/$name")
             }
         }
     }


}


