package com.boranfrkn.uchihanime.ui.detail_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boranfrkn.uchihanime.data.Result
import com.boranfrkn.uchihanime.data.response.AnimeDetailResponse
import com.boranfrkn.uchihanime.ui.detail_screen.data.AnimeDetailRepository
import com.boranfrkn.uchihanime.ui.detail_screen.data.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeDetailRepository: AnimeDetailRepository
): ViewModel() {

    private var _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    fun getAnimeDetail(animeId: Int){
        viewModelScope.launch {
            animeDetailRepository.getAnimeDetail(animeId).collect { result ->
                when(result){
                    is Result.Success -> {
                        _state.value = _state.value.copy(
                            animeDetail = result.data
                        )
                    }
                    is Result.Error -> {
                        Log.e("error", "${result.exception}")
                    }
                }
            }
        }
    }
}