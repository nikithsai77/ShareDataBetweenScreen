@file:OptIn(ExperimentalMaterial3Api::class)

package com.android.sharedata.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PassDataInNavHost() {
    var title by remember {
        mutableStateOf(value = "")
    }
    val navController = rememberNavController()
    navController.addOnDestinationChangedListener {controller, _, _ ->
        title = controller.currentDestination?.route ?: ""
    }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = title) },
            colors =TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                if (title.equals(other = "Screen2", ignoreCase = true)) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                        modifier = Modifier.clickable {  }
                    )
                }
            }
        )
    }) { paddingValue ->
        println("kk $paddingValue")
        NavHost(navController = navController, startDestination = "Screen1") {
            composable(route = "Screen1") { ScreenOne(it) { navController.navigate(route = "Screen2") } }
            composable(route = "Screen2") {
                ScreenTwo {
                    navController.previousBackStackEntry?.savedStateHandle?.set("send", it)
                    navController.popBackStack()
                }
            }
        }
    }
}

@Composable
fun ScreenOne(onNavigate: NavBackStackEntry, onNavigator: (String) -> Unit) {
    val text : String? = onNavigate.savedStateHandle.get<String>("send")
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        text?.let { newText ->
            Text(text = newText)
        }
        Button(onClick = { onNavigator("Screen2") }) {
            Text(text = "Go To Next Screen")
        }
    }
}

@Composable
fun ScreenTwo(onNavigator: (String) -> Unit) {
    var text by remember {
        mutableStateOf(value = "")
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.width(300.dp)
        )
        Button(onClick = { onNavigator(text) }) {
            Text(text = "Send Back to Previous Screen")
        }
    }
}