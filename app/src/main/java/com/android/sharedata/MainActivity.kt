package com.android.sharedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.sharedata.ui.theme.ShareDataTheme
import com.android.sharedata.util.NavigationComposeWithOutRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareDataTheme {
                NavigationComposeWithOutRoute()
            }
        }
    }
}

@Preview
@Composable
fun MPreview() {
    ShareDataTheme {
        NavigationComposeWithOutRoute()
    }
}