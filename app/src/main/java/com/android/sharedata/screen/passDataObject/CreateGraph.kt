package com.android.sharedata.screen.passDataObject

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.android.sharedata.screen.passNormalData.SettingScreen

@Composable
fun CreateGraph(navController: NavHostController, paddingValues: PaddingValues) : NavGraph {
    return navController.createGraph(startDestination = "HomeScreen") {
        composable(route = "HomeScreen") { HomeScreen(navController = navController, modifier = Modifier.padding(paddingValues)) }
        composable(route = "ProfileScreen/{data}") {
            val data = it.arguments?.getString("data") ?: "No Data Sent"
            navController.currentBackStackEntry?.arguments?.apply {
                putString("data", data)
            }
            ProfileScreen(navController = navController, modifier = Modifier.padding(paddingValues)) }
        composable(route = "SettingScreen") { SettingScreen(navController = navController, modifier = Modifier.padding(paddingValues)) }
    }
}