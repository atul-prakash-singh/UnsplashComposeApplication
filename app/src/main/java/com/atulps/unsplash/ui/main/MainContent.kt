package com.atulps.unsplash.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atulps.unsplash.shared.data.model.Image
import com.atulps.unsplash.ui.about.AboutContent
import com.atulps.unsplash.ui.theme.BottomNavigationHeight
import com.atulps.unsplash.ui.theme.colorContent
import com.atulps.unsplash.ui.home.HomeContent

private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(
    navController: NavHostController,
    images: State<List<Image>?>,
    onSearchAction: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(bottom = BottomNavigationHeight)
            .background(colorContent)

    ) {
        MainScreenNavigationConfigurations(
            navController = navController,
            images = images,
            onSearchAction = onSearchAction
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    images: State<List<Image>?>,
    onSearchAction: (String) -> Unit
) {

    NavHost(navController, startDestination = DEFAULT_SCREEN.route) {
        composable(BottomNavigationScreens.Home.route) {
            HomeContent(
                images = images.value ?: emptyList(),
                onSearchAction = onSearchAction
            )
        }
        composable(BottomNavigationScreens.About.route) {
            AboutContent()
        }
    }
}