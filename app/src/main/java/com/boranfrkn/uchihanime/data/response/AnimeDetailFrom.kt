package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailFrom(
    @SerializedName("day")
    val day: Int?,
    @SerializedName("month")
    val month: Int?,
    @SerializedName("year")
    val year: Int?
)