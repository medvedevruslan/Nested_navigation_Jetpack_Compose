package com.medvedev.nested_navigation_jetpack_compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.medvedev.nested_navigation_jetpack_compose.navigation.Screens

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            text = "to signUp: Login",
            modifier = Modifier.clickable {
                navController.navigate(route = Screens.SignUp.route)
            },
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Open detail screen",
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                    navController.navigate(Screens.Detail.passNameAndId())
                }
                .padding(top = 20.dp),
        )
        
        NavigationInfo(navController = navController)

    }

}