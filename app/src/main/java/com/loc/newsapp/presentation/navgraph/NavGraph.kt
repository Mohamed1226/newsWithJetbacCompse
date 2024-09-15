package com.loc.newsapp.presentation.navgraph

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.loc.newsapp.presentation.onboarding.OnBoardingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        Log.d("TEST startDestination", startDestination)
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                OnBoardingScreen()
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                Scaffold {
                    Text("dfsdsf")
                }
            }
            composable(route = Route.SearchScreen.route) {

            }
            composable(route = Route.BookmarkScreen.route) {

            }
            composable(route = Route.DetailsScreen.route) {

            }
        }
    }
}