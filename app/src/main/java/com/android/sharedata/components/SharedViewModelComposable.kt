package com.android.sharedata.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.android.sharedata.viewModel.SharedViewModel

@Composable
fun SharedViewModelComposable() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "onBoarding") {
        navigation(startDestination = "personal_details", route = "onBoarding") {
            composable(route = "personal_details") {
                val sharedViewModel = it.sharedViewModel<SharedViewModel>(navController = navController)
                val state by sharedViewModel.stateFlow.collectAsStateWithLifecycle()
                PersonalDetailScreen(state = state, buttonClick = { sharedViewModel.updateState() }, navigate = { navController.navigate(route = "terms_and_condition") }, text = "Move To Terms and Condition Screen")
            }
            composable(route = "terms_and_condition") {
                val sharedViewModel = it.sharedViewModel<SharedViewModel>(navController = navController)
                val state by sharedViewModel.stateFlow.collectAsStateWithLifecycle()
                PersonalDetailScreen(state = state, buttonClick = { sharedViewModel.updateState() }, navigate = {
                    navController.navigate(route = "other_screen") {
                        popUpTo(route = "onBoarding") {
                            inclusive = true
                        }
                    }
                    navController.popBackStack()
                }, text = "Move To Other Screen")
            }
        }
        composable("other_screen") {
            Text(text = "Hello World!")
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: "onBoarding"
    val parentEntry = navController.getBackStackEntry(navGraphRoute)
    return viewModel(parentEntry)
}

@Composable
fun PersonalDetailScreen(state: Int, buttonClick: () -> Unit, navigate: () -> Unit, text: String) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { buttonClick() }) {
            Text(text = "Click Here To Update The Value: $state")
        }
        Button(onClick = { navigate.invoke() }) {
            Text(text = text)
        }
    }
}