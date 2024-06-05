package com.abudnitski.imagesearcher.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abudnitski.imagesearcher.ui.detailScreen.DetailScreen
import com.abudnitski.imagesearcher.ui.mainScreen.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(topBar = {
        if (navController.equals((Screen.Preview.route))) {
            TopAppBar(title = {})
        }
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Main.route) {
                MainScreen(onGoToDetail = {
                    navController.navigate(
                        Screen.Preview.route.replace(
                            oldValue = "{$PHOTO_ID}",
                            newValue = "$it"
                        )
                    )
                })
            }
            composable(Screen.Preview.route) {
                DetailScreen(onBackClick = { navController.popBackStack() })
            }
        }
    }
}

const val PHOTO_ID = "photo_id"

enum class Screen(val route: String) {
    Main("main/"),
    Preview("detail?photoId={$PHOTO_ID}")
}