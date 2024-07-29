package com.example.m16_recycler_retrofit.pagedmovielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.m16_recycler_retrofit.databinding.MovieItemBinding
import com.example.m16_recycler_retrofit.models.Movie
import com.example.m16_recycler_retrofit.movielist.MovieViewHolder
import com.google.android.material.snackbar.Snackbar

class MoviePagedListAdapter: PagingDataAdapter<Movie, MovieViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            movieTitle.text = item?.nameRu ?: ""
            movieGenres.text = item?.genres?.joinToString(", ") {it.genre}
            movieDescription.text = "Премьера ${item?.year}"
            movieCountry.text = item?.countries?.joinToString (", ") {it.country}
            item?.let{
                Glide
                    .with(movieCover.context)
                    .load(it.posterUrlPreview)
                    .into(movieCover)
            }
        }
        holder.binding.root.setOnClickListener {
            Snackbar.make(holder.binding.root, item?.nameRu.toString(), Snackbar.LENGTH_LONG).show()
        }
    }
}

class DiffUtilCallback: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.kinopoiskId == newItem.kinopoiskId

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem == newItem

}