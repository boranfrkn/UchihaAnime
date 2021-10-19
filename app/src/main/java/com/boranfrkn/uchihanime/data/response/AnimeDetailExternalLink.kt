package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailExternalLink(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)