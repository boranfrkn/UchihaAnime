package com.boranfrkn.uchihanime.ui.list_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberImagePainter
import com.boranfrkn.uchihanime.R
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse

@ExperimentalFoundationApi
@Composable
fun animeListView(state: LazyPagingItems<TopListAnimeResponse>, navController: NavController){
    LazyVerticalGrid(cells = GridCells.Fixed(2)){
        items(state.itemCount) { item ->
            AnimeEntry(anime = state[item]!!, navController = navController)
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier) {
        TextField(
            value = text,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    5.dp,
                    RoundedCornerShape(26.dp)
                ),
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {
                text = it
                onSearch(it)
            },
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.primary,
                textColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.Gray
            ),
            shape = CircleShape
        )
    }
}


@Composable
fun AnimeEntry(
    anime: TopListAnimeResponse,
    navController: NavController
) {
    AnimeItemCard(anime = anime, navController = navController)
}

@Composable
fun AnimeItemCard(
    anime: TopListAnimeResponse,
    navController: NavController
){
    Card(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp
    ) {
        AnimeItemBox(anime = anime, navController = navController)
    }
}

@Composable
fun AnimeItemBox(
    anime: TopListAnimeResponse,
    navController: NavController
){
    Box(modifier = Modifier
        .height(260.dp)
        .clickable {
            navController.navigate("anime_detail_screen/${anime.malId}")
        } ){
        AnimeImageView(anime = anime)
        AnimeGradientColor()
        AnimeNameView(anime = anime)
    }
}

@Composable
fun AnimeImageView(anime: TopListAnimeResponse){
    Image(
        painter = rememberImagePainter(anime.imageUrl),
        contentDescription = anime.title,
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .size(260.dp),
        contentScale = ContentScale.FillBounds,
    )
}

@Composable
fun AnimeNameView(anime: TopListAnimeResponse){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.BottomCenter) {
        Text(
            text = anime.title.toString(),
            style = TextStyle(color = Color.White, fontSize = 16.sp)
        )
    }
}

@Composable
fun AnimeGradientColor(){
    Box (
        modifier = Modifier
            .size(260.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = 200f,
                )
            )
    )
}