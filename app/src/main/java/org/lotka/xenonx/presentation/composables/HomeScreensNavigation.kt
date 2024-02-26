package com.kilid.portal.presentation.ui.navigation

sealed class HomeScreensNavigation(val route: String) {


    object weather : HomeScreensNavigation(route = "weather")
    object ChatHome : HomeScreensNavigation(route = "ChatHome")
    object RegisterScreen : HomeScreensNavigation(route = "Register")
    object LoginScreen : HomeScreensNavigation(route = "login")

}