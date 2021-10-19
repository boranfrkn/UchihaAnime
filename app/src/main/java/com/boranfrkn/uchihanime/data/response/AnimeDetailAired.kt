package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailAired(
    @SerializedName("from")
    val from: String?,
    @SerializedName("prop")
    val prop: AnimeDetailProp?,
    @SerializedName("string")
    val string: String?,
    @SerializedName("to")
    val to: String?
)