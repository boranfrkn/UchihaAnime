package com.boranfrkn.uchihanime.ui.list_screen.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.boranfrkn.uchihanime.data.AnimeApi
import com.boranfrkn.uchihanime.data.response.TopListAnimeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeSource @Inject constructor(
    private val animeApi: AnimeApi,
) : PagingSource<Int, TopListAnimeResponse>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, TopListAnimeResponse> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = animeApi.getTopAnime(nextPageNumber)
            Log.e("result", "${response.topListAnimeResponse}")
            LoadResult.Page(
                data = response.topListAnimeResponse!!,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1, // Only paging forward.
                nextKey = nextPageNumber.plus(1)
            )
        }
        catch (e: Exception) {
            Log.e("error2", "$e")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TopListAnimeResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override val keyReuseSupported: Boolean = true

}