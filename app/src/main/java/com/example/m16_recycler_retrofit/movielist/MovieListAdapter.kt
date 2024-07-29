package com.example.m16_recycler_retrofit.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.m16_recycler_retrofit.databinding.MovieItemBinding
import com.example.m16_recycler_retrofit.models.Movie

class MovieListAdapter: ListAdapter<Movie, MovieViewHolder>(DiffUtilCallback()) {

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
            movieDescription.text = "Премьера ${item?.premiereRu}"
            movieCountry.text = item?.countries?.joinToString (", ") {it.country}
            item?.let{
                Glide
                    .with(movieCover.context)
                    .load(it.posterUrlPreview)
                    .into(movieCover)
            }
        }
        holder.binding.root.setOnClickListener {  }
    }
}

class DiffUtilCallback: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.kinopoiskId == newItem.kinopoiskId

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem == newItem

}