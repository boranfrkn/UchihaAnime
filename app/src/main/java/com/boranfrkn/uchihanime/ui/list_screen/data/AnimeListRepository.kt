package com.boranfrkn.uchihanime.ui.list_screen.data

import com.boranfrkn.uchihanime.base.BaseRepository
import com.boranfrkn.uchihanime.data.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeListRepository @Inject constructor(
    private val animeSource: AnimeSource
): BaseRepository() {
    suspend fun getTopAnimeList(): Flow<Result<AnimeSource>> {
        return apiCall { animeSource }
    }
}