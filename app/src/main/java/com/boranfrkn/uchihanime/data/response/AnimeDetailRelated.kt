package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailRelated(
    @SerializedName("Adaptation")
    val adaptation: List<AnimeDetailAdaptation>?,
    @SerializedName("Other")
    val other: List<AnimeDetailOther>?,
    @SerializedName("Prequel")
    val prequel: List<AnimeDetailPrequel>?,
    @SerializedName("Sequel")
    val sequel: List<AnimeDetailSequel>?,
    @SerializedName("Side story")
    val sideStory: List<AnimeDetailSideStory>?,
    @SerializedName("Spin-off")
    val spinOff: List<AnimeDetailSpinOff>?
)