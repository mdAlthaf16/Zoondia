package com.task.zoondia.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.task.zoondia.navigation.LocalNavController
import com.task.zoondia.navigation.SetupNavGraph
import com.task.zoondia.ui.theme.ZoondiaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoondiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavigationSetup()
                }
            }
        }
    }
}

@Composable
fun NavigationSetup() {

    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        SetupNavGraph(navController)
    }

}