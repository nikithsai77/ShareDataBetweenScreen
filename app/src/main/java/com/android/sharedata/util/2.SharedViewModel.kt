package com.android.sharedata.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.android.sharedata.screen.ScreenOne
import com.android.sharedata.screen.ScreenTwo
import com.android.sharedata.viewModel.ShareViewModel

@Composable
fun getGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, graph = GetCreateGraph(navController = navController, paddingValues, shareViewModel = viewModel()))
}

@Composable
fun GetCreateGraph(navController: NavController, paddingValues: PaddingValues, shareViewModel: ShareViewModel): NavGraph {
    return navController.createGraph(route = "okay",startDestination = "ScreenOne") {
        composable(route = "ScreenOne") {
            ScreenOne(navController = navController, sharedViewModel = shareViewModel, modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues))
        }
        composable(route = "ScreenTwo") {
            ScreenTwo(navController = navController, sharedViewModel = shareViewModel, modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues))
        }
    }
}