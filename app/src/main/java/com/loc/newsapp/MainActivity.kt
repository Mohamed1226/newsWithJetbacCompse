package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loc.newsapp.presentation.navgraph.NavGraph
import com.loc.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainViewModel>()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.showSplash
            }
        }

        setContent {

            NewsAppTheme {
                ///control app bar colors
                val isDarkMode = isSystemInDarkTheme()
                val uiController = rememberSystemUiController()
                SideEffect {
                    uiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isDarkMode
                    )

                }
                NavGraph(startDestination = viewModel.startDestination)
            }
        }
    }
}
