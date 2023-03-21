package com.example.myvestiaireweather.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myvestiaireweather.domain.model.WeatherData
import com.example.myvestiaireweather.presentation.detail.main.DetailScreen
import com.example.myvestiaireweather.presentation.detail.main.MainScreen
import com.example.myvestiaireweather.presentation.detail.main.WeatherViewModel

@Composable
fun NavGraph(
    navController: NavHostController, viewModel: WeatherViewModel
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            "${Screen.DetailScreen.route}/{index}"
        ){
            it.arguments?.getString("index")?.let { index ->
                DetailScreen(
                    navController = navController,
                    index = index.toInt(),
                    viewModel = viewModel
                )
            }
        }
    }

}