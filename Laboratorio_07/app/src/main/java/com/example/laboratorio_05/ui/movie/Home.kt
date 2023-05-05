package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.data.model.movies
import com.example.laboratorio_05.databinding.FragmentDescriptionBinding
import com.example.laboratorio_05.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class Home : Fragment() {

    private lateinit var cardView: CardView
    private lateinit var plus: FloatingActionButton

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        plus = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
        cardView = view?.findViewById(R.id.card_view_star_wars) as CardView

        cardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_home2_to_description2)
        }

        plus.setOnClickListener {
            it.findNavController().navigate(R.id.action_home2_to_addMovie2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

}