package com.example.m16_recycler_retrofit.movielist

import com.example.m16_recycler_retrofit.api.retrofit
import com.example.m16_recycler_retrofit.models.Movie

class MovieListRepository {
    suspend fun getPremieres(year: Int, month: String): List<Movie> {
        return retrofit.movies(year, month).items
    }
}