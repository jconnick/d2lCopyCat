package com.example.copycat

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.copycat.ui.theme.CopyCatTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.rememberNavController
import com.example.copycat.ui.CopyCatViewModel
import androidx.navigation.compose.currentBackStackEntryAsState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val copyCatViewModel : CopyCatViewModel by viewModels()
        setContent {
            CopyCatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    Scaffold(

                        // Bottom navigation
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            // Nav host: where screens are placed
                            NavHostContainer(navController = navController, padding = padding, copyCatViewModel = copyCatViewModel)
                        }
                    )
                }
            }
        }
    }
}
