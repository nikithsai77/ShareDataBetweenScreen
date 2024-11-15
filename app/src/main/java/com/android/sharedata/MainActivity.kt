@file:OptIn(ExperimentalMaterial3Api::class)

package com.android.sharedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.sharedata.ui.theme.ShareDataTheme
import com.android.sharedata.util.PassDataInNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareDataTheme {
                PassDataInNavHost()
            }
        }
    }
}

@Preview
@Composable
fun MPreview() {
    ShareDataTheme {
        PassDataInNavHost()
    }
}
