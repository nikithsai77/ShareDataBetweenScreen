package com.android.sharedata.screen.passNormalData

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

@Composable
fun SettingScreen(navController: NavController, modifier: Modifier = Modifier.fillMaxSize()) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Move Back")
            }
            Text(text = "Setting Screen")
            Button(onClick = { navController.popBackStack(navController.graph.startDestinationId, inclusive = false)}) {
                Text(text = "Click for Home")
            }
        }
    }
}