package com.example.myvestiaireweather.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("Detail_screen")

}
