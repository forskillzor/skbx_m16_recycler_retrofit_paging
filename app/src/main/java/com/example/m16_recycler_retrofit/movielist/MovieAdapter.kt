package com.example.m16_recycler_retrofit.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m16_recycler_retrofit.databinding.MovieItemBinding
import com.example.m16_recycler_retrofit.models.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var data: List<Movie> = emptyList()
    fun setData(data: List<Movie>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

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
        val item = data.getOrNull(position)
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
    }
}

class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)