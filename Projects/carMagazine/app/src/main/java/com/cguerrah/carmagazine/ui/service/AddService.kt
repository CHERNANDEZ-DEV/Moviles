package com.cguerrah.carmagazine.ui.service

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cguerrah.carmagazine.databinding.FragmentAddServiceBinding

class AddService : Fragment() {

    // Se obtiene una instancia del viewModel

    private val serviceViewModel:ServiceViewModel by activityViewModels{ ServiceViewModel.Factory }

    // Se crea la variable binding del tipo FragmentAddServiceBinding

    private lateinit var binding: FragmentAddServiceBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Se procede a inflar la vista por medio de DataBinding

        binding = FragmentAddServiceBinding.inflate(inflater, container, false)
        return binding.root
    }


    // Se enlaza el ViewModel con su respectiva vista

    private fun setViewModel(){
        binding.viewmodel = serviceViewModel
    }

    // Se debe observar el estado del viewModel y tomar decisiones en consecuencia

    private fun observeStatus(){
        serviceViewModel.status.observe(viewLifecycleOwner) {status ->
            when{

                status.equals(ServiceViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    serviceViewModel.clearStatus()
                }

                status.equals(ServiceViewModel.SERVICE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", serviceViewModel.getServices().toString())

                    serviceViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }
}