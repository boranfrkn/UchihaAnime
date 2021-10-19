package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailGenre(
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)