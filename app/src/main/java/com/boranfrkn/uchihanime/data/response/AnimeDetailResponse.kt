package com.boranfrkn.uchihanime.data.response


import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(
    @SerializedName("aired")
    val aired: AnimeDetailAired?,
    @SerializedName("airing")
    val airing: Boolean?,
    @SerializedName("background")
    val background: Any?,
    @SerializedName("broadcast")
    val broadcast: String?,
    @SerializedName("demographics")
    val demographics: List<AnimeDetailDemographic>?,
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("ending_themes")
    val endingThemes: List<String>?,
    @SerializedName("episodes")
    val episodes: Int?,
    @SerializedName("explicit_genres")
    val explicitGenres: List<Any>?,
    @SerializedName("external_links")
    val externalLinks: List<AnimeDetailExternalLink>?,
    @SerializedName("favorites")
    val favorites: Int?,
    @SerializedName("genres")
    val genres: List<AnimeDetailGenre>?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("licensors")
    val licensors: List<AnimeDetailLicensor>?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("members")
    val members: Int?,
    @SerializedName("opening_themes")
    val openingThemes: List<String>?,
    @SerializedName("popularity")
    val popularity: Int?,
    @SerializedName("premiered")
    val premiered: String?,
    @SerializedName("producers")
    val producers: List<AnimeDetailProducer>?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("related")
    val related: AnimeDetailRelated?,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    val requestCached: Boolean?,
    @SerializedName("request_hash")
    val requestHash: String?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("scored_by")
    val scoredBy: Int?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("studios")
    val studios: List<AnimeDetailStudio>?,
    @SerializedName("synopsis")
    val synopsis: String?,
    @SerializedName("themes")
    val themes: List<AnimeDetailTheme>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_english")
    val titleEnglish: String?,
    @SerializedName("title_japanese")
    val titleJapanese: String?,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>?,
    @SerializedName("trailer_url")
    val trailerUrl: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)