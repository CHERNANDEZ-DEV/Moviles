package com.example.laboratorio_05.ui.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_05.MovieReviewerApplication
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel(){

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun setSelectedMovie(movie: MovieModel){
        name.value = movie.name
        category.value = movie.name
        description.value = movie.category
        qualification.value = movie.qualification
    }

    fun getMovies() = repository.getMovies()

    fun addMovies(movie : MovieModel) = repository.addMovies(movie)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }


    fun clearStatus(){
        status.value = INACTIVE
    }

    fun createMovie(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovies(movie)
        clearData()
        status.value = MOVIE_CREATED
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}