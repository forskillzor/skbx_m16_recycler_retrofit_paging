package com.example.m16_recycler_retrofit.api

import com.example.m16_recycler_retrofit.models.MovieList
import com.example.m16_recycler_retrofit.models.PagedMovieList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private const val API_KEY = "aa41fa43-639e-4ec1-b358-a6769fa0a85b"

interface MovieListApi {
    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/premieres")
    suspend fun movies(@Query("year") year: Int, @Query("month") month: String): MovieList

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/top?=type=TOP_250_BEST_FILMS")
    suspend fun topList(@Query("page") page: Int): PagedMovieList
}

val retrofit: MovieListApi = Retrofit
    .Builder()
    .client(
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }).build()
    )
    .baseUrl("https://kinopoiskapiunofficial.tech")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(MovieListApi::class.java)