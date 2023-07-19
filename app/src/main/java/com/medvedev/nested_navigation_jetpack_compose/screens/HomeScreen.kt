package com.medvedev.nested_navigation_jetpack_compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.medvedev.nested_navigation_jetpack_compose.navigation.AUTH_GRAPH_ROUTE
import com.medvedev.nested_navigation_jetpack_compose.navigation.Screens
import com.medvedev.nested_navigation_jetpack_compose.printD

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Home.toDetail with args",
            modifier = Modifier
                .padding(25.dp)
                .clickable {
                    navController.navigate(
                        route = Screens.Detail.passNameAndId(
                            id = 11,
                            name = "John"
                        )
                    )
                },
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Login/SignUp",
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            modifier = Modifier.clickable {
                navController.navigate(route = AUTH_GRAPH_ROUTE)
            },
            fontWeight = FontWeight.Medium
        )
        NavigationInfo(navController = navController)
    }
}

@Composable
fun NavigationInfo(navController: NavController) {

    Spacer(modifier = Modifier.padding(24.dp))

    val currentBackStackEntry = navController.currentBackStackEntry
    "currentBackStackEntry: ${currentBackStackEntry.toString()}".printD

    val currentDestination = currentBackStackEntry?.destination?.id
    "currentDestination: ${currentDestination.toString()}".printD

    val label = currentBackStackEntry?.destination?.label
    "label: ${label.toString()}".printD

    val id = currentBackStackEntry?.id
    "id: ${id.toString()}".printD

    val route = currentBackStackEntry?.destination?.route
    "route: ${route.toString()}".printD

    Text(text = "currentBackStackEntry = ${currentBackStackEntry.toString()}")
    Spacer(modifier = Modifier.padding(24.dp))
    Text(text = "currentDestination = ${currentDestination.toString()}")
    Spacer(modifier = Modifier.padding(24.dp))
    Text(text = "label = ${label.toString()}")
    Spacer(modifier = Modifier.padding(24.dp))
    Text(text = "id = ${id.toString()}")
    Spacer(modifier = Modifier.padding(24.dp))
    Text(text = "route = ${route.toString()}")
}