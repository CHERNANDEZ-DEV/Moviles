package com.example.laboratorio_05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.FragmentHomeBinding
import com.example.laboratorio_05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLinkNewMovie.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_addMovie2)
        }

        binding.cardViewHarrypotter2.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_description2)
        }
    }

    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_home2_to_description2)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
}