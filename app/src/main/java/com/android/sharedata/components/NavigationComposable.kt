package com.android.sharedata.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.android.sharedata.screen.passNormalData.HomeScreen
import com.android.sharedata.screen.passNormalData.ProfileScreen
import com.android.sharedata.screen.passNormalData.SettingScreen

@Composable
fun NavigationComposable(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {  HomeScreen(navController = navController) }
        composable(route = "ProfileScreen") {  ProfileScreen(navController = navController) }
        composable(route = "SettingScreen") {  SettingScreen(navController = navController) }
    }
}

@Composable
fun CustomNavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, graph = CreateGraph(navController = navController, paddingValues))
}

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