package com.boranfrkn.uchihanime.ui.detail_screen

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SetJavaScriptEnabled", "WrongConstant", "RememberReturnType")
@Composable
fun DetailScreen(
    navController: NavController,
    animeId: Int,
    viewModel: AnimeDetailViewModel = hiltViewModel()
){
    LocalLifecycleOwner.current.lifecycleScope.launchWhenResumed {
        viewModel.getAnimeDetail(animeId = animeId)
    }

    var animeDetail = viewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)

        ) {
            Text(text = animeDetail.value.animeDetail?.title?: "", color = Color.Black, fontSize = 30.sp)
        }
    }

}
