package com.medvedev.nested_navigation_jetpack_compose.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.medvedev.nested_navigation_jetpack_compose.navigation.DETAIL_ARGUMENT_KEY
import com.medvedev.nested_navigation_jetpack_compose.navigation.DETAIL_ARGUMENT_KEY2

@Composable
fun DetailScreen(navController: NavController) {
    val arguments = navController.previousBackStackEntry?.arguments
    val idArgs = arguments?.getString(DETAIL_ARGUMENT_KEY)
    val nameArgs = arguments?.getString(DETAIL_ARGUMENT_KEY2)
    Text(text = "this is detail screen. ID = $idArgs NAME = $nameArgs")
}