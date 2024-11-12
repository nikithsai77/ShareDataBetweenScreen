package com.android.sharedata.screen.passDataObject

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.android.sharedata.data.Movie
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier.fillMaxSize()) {
    val movie = Movie(name = "The Mummy")
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {
        Column(modifier = modifier.background(Color.Green), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Screen")
            val json = Json{ prettyPrint = true }
            val data = json.encodeToString(movie)
            Button(onClick = { navController.navigate(route = "ProfileScreen/$data") }) {
                Text(text = "Click for Profile")
            }
        }
    }
}