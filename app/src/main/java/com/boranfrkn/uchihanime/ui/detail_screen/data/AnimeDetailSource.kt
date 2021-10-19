package com.boranfrkn.uchihanime.ui.detail_screen.data

import com.boranfrkn.uchihanime.data.AnimeApi
import javax.inject.Inject

class AnimeDetailSource @Inject constructor(
    private val animeApi: AnimeApi
) {
    suspend fun getAnimeDetail(animeId: Int) = animeApi.getAnimeDetail(animeId)
}