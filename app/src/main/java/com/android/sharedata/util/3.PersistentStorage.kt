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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.sharedata.viewModel.PersistentOneViewModel
import com.android.sharedata.viewModel.PersistentTwoViewModel

@Composable
fun PersistentStorageSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ScreenOne") {
        composable(route = "ScreenOne") {
            val itemViewModel: PersistentOneViewModel = hiltViewModel()
            Sample(text = itemViewModel.getMovie()) {
                itemViewModel.setMovie()
                navController.navigate(route = "ScreenTwo")
            }
        }
        composable(route = "ScreenTwo") {
            val itemViewModel: PersistentTwoViewModel = hiltViewModel()
            Sample(text = "The Movie Name is: ${itemViewModel.getMovie()}") {
                itemViewModel.clearMovieName()
                navController.popBackStack()
            }
        }
    }
}

@Composable
fun Sample(text: String, navigate: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navigate() }) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun Preview() {
    PersistentStorageSample()
}