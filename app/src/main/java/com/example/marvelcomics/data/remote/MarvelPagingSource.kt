package com.example.marvelcomics.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelcomics.data.remote.response.CharactersDto
import retrofit2.HttpException
import java.io.IOException

class MarvelPagingSource(
    private val apiService: MarvelService
) : PagingSource<Int, CharactersDto>() {
    override fun getRefreshKey(state: PagingState<Int, CharactersDto>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharactersDto> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharactersByPaging(currentPage)
            val responseData = mutableListOf<CharactersDto>()
            val data = response.body()?.data?.results ?: emptyList()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
