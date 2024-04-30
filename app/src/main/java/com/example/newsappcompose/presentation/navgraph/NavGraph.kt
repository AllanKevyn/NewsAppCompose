package com.example.newsappcompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsappcompose.presentation.home.HomeScreen
import com.example.newsappcompose.presentation.home.HomeViewModel
import com.example.newsappcompose.presentation.onboarding.OnBoardingScreen
import com.example.newsappcompose.presentation.onboarding.viewModel.OnBoardingViewModel
import com.example.newsappcompose.presentation.search.SearchScreen
import com.example.newsappcompose.presentation.search.SearchViewModel

@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent // another way to do event = {viewModel.onEvent(it)}
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ) {
            composable(
                route = Route.NewsNavigationScreen.route
            ) {
               val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(searchState = viewModel.state.value, event = viewModel::onEvent, navigate = {})
            }
        }
    }
}