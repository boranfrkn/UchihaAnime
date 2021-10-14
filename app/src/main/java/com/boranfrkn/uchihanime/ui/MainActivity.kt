package com.boranfrkn.uchihanime.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.multidex.MultiDex
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.boranfrkn.uchihanime.ui.detail_screen.DetailScreen
import com.boranfrkn.uchihanime.ui.list_screen.ListScreen
import com.boranfrkn.uchihanime.ui.list_screen.ListViewModel
import com.boranfrkn.uchihanime.ui.theme.UchihaAnimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ListViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MultiDex.install(applicationContext)
        setContent {
            UchihaAnimeTheme() {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "list_screen"
                ){
                    composable("list_screen"){
                        ListScreen(
                            animes = viewModel.animes,
                            navController = navController
                        )
                    }
                    composable(
                        "anime_detail_screen/{anime_id}",
                        arguments = listOf(navArgument("anime_id"){
                            type = NavType.IntType
                        })
                    ){
                        DetailScreen(navController = navController, animeId = it.arguments?.getInt("anime_id")?: 0)
                    }
                }

            }
        }
    }

}

