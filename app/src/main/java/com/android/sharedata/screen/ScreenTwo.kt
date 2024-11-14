package com.android.sharedata.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.android.sharedata.viewModel.ShareViewModel

@Composable
fun ScreenTwo(navController: NavController, sharedViewModel: ShareViewModel, modifier: Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Received Data is: ${sharedViewModel.liveData.value}")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Move Back")
        }
    }
}
