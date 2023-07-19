package com.medvedev.nested_navigation_jetpack_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.medvedev.nested_navigation_jetpack_compose.screens.AboutScreen
import com.medvedev.nested_navigation_jetpack_compose.screens.DetailScreen
import com.medvedev.nested_navigation_jetpack_compose.screens.HomeScreen
import com.medvedev.nested_navigation_jetpack_compose.screens.LoginScreen
import com.medvedev.nested_navigation_jetpack_compose.screens.SignInScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
        composable(route = Screens.About.route) {
            AboutScreen()
        }
    }
}


// https://github.com/stevdza-san/NestedNavigationDemo

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = Screens.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Detail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_KEY)
            val name = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_KEY2)
        }

        /*arguments = listOf(
            navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
                defaultValue = 0
            },
            navArgument(DETAIL_ARGUMENT_KEY2) {
                type = NavType.StringType
                defaultValue = "Nested Lesson Stevdza"
            }
        )) {
        DetailScreen(navController)
    }*/

        composable(route = Screens.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Nested Lesson Stevdza"
                }
            )) {
            DetailScreen(navController)
        }

    }
}


fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Screens.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.SignUp.route) {
            SignInScreen(navController = navController)
        }
    }
}