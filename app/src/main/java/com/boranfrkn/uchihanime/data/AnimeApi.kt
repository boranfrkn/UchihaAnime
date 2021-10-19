package com.boranfrkn.uchihanime.data

import com.boranfrkn.uchihanime.data.response.AnimeDetailResponse
import com.boranfrkn.uchihanime.data.response.GetTopListAnimeMain
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("/v3/top/anime/{page}")
    suspend fun getTopAnime(@Path("page") page: Int) : GetTopListAnimeMain

    @GET("/v3/anime/{animeId}")
    suspend fun getAnimeDetail(@Path("animeId") animeId: Int) : AnimeDetailResponse

}