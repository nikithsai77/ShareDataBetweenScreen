package com.android.sharedata.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object ScreenA

@Serializable
data class ScreenB(val name: String, val age: Int)

@Composable
fun NavigationComposeWithOutRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenA) {
        composable<ScreenA> {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { navController.navigate(ScreenB(name = "Mr.Bean", age = 50)) }) {
                    Text(text = "Go To Screen B")
                }
            }
        }
        composable<ScreenB> {
            val screenB = it.toRoute<ScreenB>()
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "${screenB.name} and age is ${screenB.age}")
            }
        }
    }
}

@Preview
@Composable
fun SamplePreview() {
    NavigationComposeWithOutRoute()
}
