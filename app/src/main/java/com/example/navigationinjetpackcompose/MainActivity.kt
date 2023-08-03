package com.example.navigationinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationinjetpackcompose.ui.theme.NavigationInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayNav()

                }
            }
        }
    }
}

@Composable
fun DisplayNav(){
    // Nav Controller: Keeps track of the back stack of composables
    //  and the state of each one.
    val navController = rememberNavController()

    // Nav Host :- Responsible for hosting the content of the NavDestination
    NavHost(navController = navController,
        startDestination = "First Screen",
        ){
        // NavGraphBuilder :- adds the destination to the nav graph
        composable(route = "First Screen"){
            FirstScreen(navController = navController)
        }

        composable(route = "Second Screen"){
            SecondScreen(navController = navController)
        }
    }
}


@Composable
fun FirstScreen(navController: NavController){
    Column {
        Text(
            text = "Welcome to the first screen",
            fontSize = 64.sp,
            color = Color.Red,
            lineHeight = 64.sp
        )
        Button(onClick = {
            navController.navigate("Second Screen")
        }) {
            Text(text = "Go to 2nd Screen")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController){
    Column {
        Text(
            text = "Welcome to the Second Screen",
            fontSize = 64.sp,
            color = Color.Green,
            lineHeight = 64.sp
        )
        Button(onClick = {
            navController.navigate("First Screen")
        }) {
            Text(text = "Go to 1st Screen")
        }
    }
}