package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailProp(
    @SerializedName("from")
    val from: AnimeDetailFrom?,
    @SerializedName("to")
    val to: AnimeDetailTo?
)