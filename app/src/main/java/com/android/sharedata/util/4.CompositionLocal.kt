package com.android.sharedata.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.sharedata.ui.theme.ShareDataTheme

//we can share data b/w composable with out passing parameter.
val LocalComposition = compositionLocalOf {
    "Default Value"
}

@Composable
fun AppRoot() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        //by using provides we can set the value to LocalComposition and even that updated value will be available to inside composable.
        //when the CompositionLocalProvider block end's then CompositionLocalProvider value will be reset to old value.
        CompositionLocalProvider(value = LocalComposition provides "newValue") {
               MyScreen()
            CompositionLocalProvider(value = LocalComposition provides "LatestValue") {
                MyScreen()
            }
            MyScreen()
        }
        MyScreen()
    }
}

@Composable
private fun MyScreen() {
    val newValue = LocalComposition.current
    Text(text = newValue, color = Color.White)
}

@Preview
@Composable
fun MPreview() {
    ShareDataTheme {
        AppRoot()
    }
}