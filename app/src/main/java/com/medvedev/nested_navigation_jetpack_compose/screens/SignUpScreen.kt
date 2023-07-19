package com.medvedev.nested_navigation_jetpack_compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun SignInScreen(navController: NavController) {

    Column() {
        Text(text = "Sign up",
            modifier = Modifier.clickable {
                navController.popBackStack()
            })
        NavigationInfo(navController = navController)
    }
}
