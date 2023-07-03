package ru.resodostudios.movies.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.resodostudios.movies.core.presentation.navigation.NavHost
import ru.resodostudios.movies.core.presentation.navigation.components.NavDrawer
import ru.resodostudios.movies.feature.movies.presentation.MoviesViewModel
import ru.resodostudios.movies.core.presentation.theme.MoviesTheme

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        
        setContent {
            MoviesTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                
                NavDrawer(navController = navController, drawerState = drawerState, scope = scope) {
                    NavHost(navController = navController, drawerState = drawerState, scope = scope)
                }
            }
        }
    }
}