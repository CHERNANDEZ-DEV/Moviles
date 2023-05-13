package com.example.laboratorio_05.ui.movie.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie : MovieModel, clickListener: (MovieModel) -> Unit){
        binding.titleTextViewMovie.text = movie.name
        binding.qualificationTextViewMovie.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }

    }
}