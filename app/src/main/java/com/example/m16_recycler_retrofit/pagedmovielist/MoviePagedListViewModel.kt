package com.example.m16_recycler_retrofit.pagedmovielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.m16_recycler_retrofit.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoviePagedListViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val filterEnabled = MutableStateFlow(false)

    val pagedMovies : Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(pageSize = 10),
        initialKey = null,
        pagingSourceFactory = {MoviePagingSource()}
    ).flow.cachedIn(viewModelScope)

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
}