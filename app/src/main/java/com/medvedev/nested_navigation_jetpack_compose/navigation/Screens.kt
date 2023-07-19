package com.medvedev.nested_navigation_jetpack_compose.navigation


const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"


sealed class Screens(val route: String) {
    object Home : Screens(route = "home_screen")

    object Detail : Screens(route = "detail_screen?id={id}&name={name}") {
        fun passNameAndId(
            id: Int = 0, name: String = "Stevdza-San"
        ): String = "detail_screen?id=$id&name=$name"
    }

    object Login : Screens(route = "login_Screen")

    object SignUp : Screens(route = "sign_up_screen")

    object About : Screens(route = "about_Screen")

}
