package com.example.laboratorio_05.ui.movie

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.data.model.movies
import com.example.laboratorio_05.repositories.MovieRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.log

class addMovie : Fragment() {

    private lateinit var name: EditText
    private lateinit var description: EditText
    private lateinit var category: EditText
    private lateinit var calification: EditText
    private lateinit var submit: Button

    private val movieViewModel:MovieViewModel by activityViewModels{ MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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