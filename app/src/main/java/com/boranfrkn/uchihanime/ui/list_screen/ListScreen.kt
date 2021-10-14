package com.boranfrkn.uchihanime.ui.list_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.boranfrkn.uchihanime.R
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse
import kotlinx.coroutines.flow.Flow

@ExperimentalFoundationApi
@Composable
fun ListScreen(
    animes: Flow<PagingData<TopListAnimeResponse>>,
    navController: NavController,
) {
    val state = animes.collectAsLazyPagingItems()
    Surface(
        modifier = Modifier
            .fillMaxHeight()
    ){
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription =  null,
                Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
                    .padding(top = 8.dp)
                    .graphicsLayer(alpha = 0.8f)
                    .size(48.dp)
            )

            SearchBar(
                hint = "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 20.dp)
            )

           animeListView(state = state, navController = navController)
        }
    }
}




