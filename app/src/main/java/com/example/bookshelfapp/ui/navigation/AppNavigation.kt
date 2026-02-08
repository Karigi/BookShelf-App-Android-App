package com.example.bookshelfapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookshelfapp.utils.BookShelfContentType


private const val TAG = "NavGraph"

enum class BookShelfNavigationScreens(val route: String) {
    HOME_SCREEN("home_screen"),
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
){
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val isShowingHomeScreen = currentRoute == BookShelfNavigationScreens.HOME_SCREEN.route

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            BookShelfContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            BookShelfContentType.LIST_AND_DETAIL
        }
        WindowWidthSizeClass.Expanded -> {
            BookShelfContentType.LIST_AND_DETAIL
        }
        else -> {
            BookShelfContentType.LIST_ONLY
        }
    }

    NavHost(
        navController = navController,
        startDestination = BookShelfNavigationScreens.HOME_SCREEN.route,
        modifier = modifier
            .fillMaxSize()
    ){
        composable(
            route = BookShelfNavigationScreens.HOME_SCREEN.route
        ) {

        }
    }

}