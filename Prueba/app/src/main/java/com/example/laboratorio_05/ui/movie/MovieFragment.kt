package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laboratorio_05.R
import com.example.laboratorio_05.databinding.FragmentDescriptionBinding

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

}