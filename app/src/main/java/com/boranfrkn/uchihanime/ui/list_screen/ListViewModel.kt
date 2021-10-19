package com.boranfrkn.uchihanime.ui.list_screen

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.boranfrkn.uchihanime.data.Result
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse
import com.boranfrkn.uchihanime.ui.list_screen.data.AnimeListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
        private val animeListRepository: AnimeListRepository
): ViewModel() {

    init {
        getAnimeTopList()
    }

    lateinit var animes: Flow<PagingData<TopListAnimeResponse>>

    private fun getAnimeTopList(){
        viewModelScope.launch {
            animeListRepository.getTopAnimeList().collect { result ->
                when(result){
                    is Result.Success -> {
                        animes = Pager(PagingConfig(pageSize = 20)){
                            result.data
                        }.flow
                    }
                    is Result.Error -> {
                        Log.e("error", "${result.exception}")
                    }
                    is Result.Loading -> {
                    }
                }
            }
        }
    }
}