package com.boranfrkn.uchihanime.ui.list_screen

import android.app.Application
import android.util.Log
import android.widget.GridLayout
import android.widget.GridView
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.HtmlCompat
import androidx.core.text.getSpans
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.boranfrkn.uchihanime.R
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse
import kotlin.coroutines.coroutineContext


@ExperimentalFoundationApi
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListViewModel = hiltViewModel()
) {
    val animes = remember {
        mutableStateOf(viewModel.animes)
    }
    val animesState = animes.value.collectAsLazyPagingItems()
    Scaffold(
        modifier = Modifier
            .fillMaxHeight()
    ){

    }
    Column(Modifier.fillMaxSize()) {
        Image(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription =  null,
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .graphicsLayer(alpha = 0.8f)
            .size(48.dp))

        SearchBar(
            hint = "Search",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 20.dp))

        animeListView(state = animesState, navController = navController)
    }
}




