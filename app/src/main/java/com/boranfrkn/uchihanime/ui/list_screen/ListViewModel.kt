package com.boranfrkn.uchihanime.ui.list_screen

import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.boranfrkn.uchihanime.data.AnimeApi
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse
import com.boranfrkn.uchihanime.ui.list_screen.data.AnimeSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
        private val animeApi: AnimeApi
): ViewModel() {

    val animes: Flow<PagingData<TopListAnimeResponse>> = Pager(PagingConfig(pageSize = 20)){
        AnimeSource(animeApi)
    }.flow
}