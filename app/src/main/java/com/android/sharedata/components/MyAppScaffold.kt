package com.android.sharedata.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.android.sharedata.util.getGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold() {
    var isBackEnabled by remember {
        mutableStateOf(value = false)
    }
    var title by remember {
        mutableStateOf(value = "")
    }
    val navController = rememberNavController()
    navController.addOnDestinationChangedListener { controller, _, _ ->
        title = controller.currentDestination?.route ?: ""
        isBackEnabled = controller.currentDestination?.route.equals(other = "HomeScreen", ignoreCase = true)
    }
    Scaffold(
        topBar = {
          TopAppBar(
              colors = TopAppBarDefaults.smallTopAppBarColors(
                  containerColor = MaterialTheme.colorScheme.primaryContainer,
                  titleContentColor = MaterialTheme.colorScheme.primary
              ),
              title = {
                  Text(text = title, style = MaterialTheme.typography.labelLarge)
              },
              navigationIcon = {
                  val navIcon = if (isBackEnabled) Icons.Filled.Home
                  else Icons.Filled.ArrowBack

                  IconButton(onClick = { if (!isBackEnabled) navController.popBackStack() }) {
                      Icon(imageVector = navIcon, contentDescription = "NavIcon")
                  }
              }
          )
        },
    ) {
        getGraph(navController, it)
    }
}