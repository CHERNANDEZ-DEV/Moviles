package com.example.laboratorio_05.ui.movie.addMovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.FragmentAddMovieBinding
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel

class AddMovie : Fragment() {

    private lateinit var name: EditText
    private lateinit var description: EditText
    private lateinit var category: EditText
    private lateinit var calification: EditText
    private lateinit var submit: Button

    private val movieViewModel: MovieViewModel by activityViewModels{ MovieViewModel.Factory }
    private lateinit var binding: FragmentAddMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()

        name = view?.findViewById(R.id.edit_text_name) as EditText
        description = view?.findViewById(R.id.edit_text_description) as EditText
        category = view?.findViewById(R.id.edit_text_category) as EditText
        calification = view?.findViewById(R.id.edit_text_calification) as EditText
        submit = view?.findViewById(R.id.btn_submit) as Button

        submit.setOnClickListener{
            var n:String = name.text.toString()
            var d:String = description.text.toString()
            var cat:String = category.text.toString()
            var cal:String = calification.text.toString()

            var nMovie =  MovieModel(n,cat,d,cal)

           movieViewModel.addMovies(nMovie)

            Log.d("movie", movieViewModel.getMovies().toString())

        }
    }
}