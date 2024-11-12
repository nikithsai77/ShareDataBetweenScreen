package com.android.sharedata.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.sharedata.data.Movie
import com.android.sharedata.viewModel.ShareViewModel

@Composable
fun ScreenOne(navController: NavController, sharedViewModel: ShareViewModel, modifier: Modifier) {
    Column(modifier = modifier.background(Color.Green), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "ScreenOne")
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            sharedViewModel.setValue(Movie(name = "The Mummy"))
            navController.navigate(route = "ScreenTwo")
        }) {
            Text(text = "Click Here To Move To ScreenTwo")
        }
}}