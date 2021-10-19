package com.boranfrkn.uchihanime.ui.detail_screen.data

import com.boranfrkn.uchihanime.base.BaseRepository
import javax.inject.Inject

class AnimeDetailRepository @Inject constructor(
    private val animeDetailSource: AnimeDetailSource
): BaseRepository(){
    suspend fun getAnimeDetail(animeId: Int) =
        apiCall { animeDetailSource.getAnimeDetail(animeId) }
}