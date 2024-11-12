package com.android.sharedata.screen.passDataObject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.android.sharedata.data.Movie
import kotlinx.serialization.json.Json

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Move Back")
            }
            val data = navController.currentBackStackEntry?.arguments?.getString("data") ?: "No Data Sent"
            val json = Json { prettyPrint = true }
            val movieData = json.decodeFromString(Movie.serializer(), data)
            Text(text = "Received Data is: $movieData")
            Button(onClick = { navController.navigate(route = "SettingScreen")}) {
                Text(text = "Click for Setting")
            }
        }
    }
}