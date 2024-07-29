package com.example.m16_recycler_retrofit.pagedmovielist

import com.example.m16_recycler_retrofit.api.retrofit
import com.example.m16_recycler_retrofit.models.Movie
import kotlinx.coroutines.delay

class MoviePagedListRepository {
    suspend fun getTopList(page: Int): List<Movie> {
        delay(1000)
        return retrofit.topList(page).films
    }
}