package com.mdsahil.ping.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mdsahil.ping.ui.home.HomeScreen
import com.mdsahil.ping.ui.splash.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ){
        composable(Routes.SPLASH){
            SplashScreen(navController)
        }

        composable(Routes.HOME){
            HomeScreen()
        }

    }
}