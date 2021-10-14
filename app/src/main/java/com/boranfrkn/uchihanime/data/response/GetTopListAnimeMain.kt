package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class GetTopListAnimeMain(
    @SerializedName("top")
    val topListAnimeResponse: List<TopListAnimeResponse>?
)