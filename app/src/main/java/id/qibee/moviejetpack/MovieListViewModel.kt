package id.qibee.moviejetpack

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import id.qibee.moviejetpack.model.DataDummy
import id.qibee.moviejetpack.model.MovieItem
import id.qibee.moviejetpack.model.MovieResponse
import java.io.IOException
import java.io.InputStream

class MovieListViewModel constructor(app: Application) : AndroidViewModel(app) {

    val movieList = MutableLiveData<List<MovieItem>>()
    var dummyMovieList : List<MovieItem> = DataDummy.addDummyMovie()
    val observableMovieList: LiveData<List<MovieItem>>
        get() = movieList

    var context: Context? = null

    init {
        context = getApplication<Application>()
    }

    fun getMovieList() {
        movieList.value = loadFromAsset().results as List<MovieItem>?
    }

    fun loadFromAsset(): MovieResponse {
        val json: String
        lateinit var movieResponse: MovieResponse
        try {
            val inputStream: InputStream? = context?.assets?.open("movie.json")
            json = inputStream?.bufferedReader().use { it?.readText().toString() }

            val gson = Gson()
            movieResponse = gson.fromJson(json, MovieResponse::class.java)

        } catch (e: IOException) {

        }
        return movieResponse


    }

}
