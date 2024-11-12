package com.android.sharedata.util

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationArguments() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "One") {
        composable(route = "One") {
            val data = 101
            Screen1(onNavigateToScreen2 = {
                navController.navigate(route = "Two/$data")
            })
        }
        composable(route = "Two/{data}") {
            val receivedData = it.arguments?.getString("data") ?: ""
            Screen2(param = receivedData)
        }
    }
}


@Composable
private fun Screen1(onNavigateToScreen2: (String) -> Unit) {
    Button(onClick = {
        onNavigateToScreen2("Hello world!")
    }) {
        Text(text = "Click me")
    }
}

@Composable
private fun Screen2(param: String) {
    Text(text = param)
}