package com.android.sharedata.screen.passNormalData

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

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier.fillMaxSize()) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {
        Column(modifier = modifier.background(Color.Green), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Screen")
            Button(onClick = { navController.navigate(route = "ProfileScreen/Hie") }) {
                Text(text = "Click for Profile")
            }
        }
    }
}