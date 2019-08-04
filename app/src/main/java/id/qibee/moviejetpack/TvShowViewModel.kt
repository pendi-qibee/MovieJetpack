package id.qibee.moviejetpack

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import id.qibee.moviejetpack.model.MovieResponse
import id.qibee.moviejetpack.model.TvItem
import id.qibee.moviejetpack.model.TvResponse
import java.io.IOException
import java.io.InputStream

class TvShowViewModel constructor(app: Application): AndroidViewModel(app) {

    private val tvShowList = MutableLiveData<List<TvItem>>()
    val observableTvList: LiveData<List<TvItem>>
        get() = tvShowList
    var context: Context? = null

    init {
        context=getApplication<Application>()
        getMovieList()
    }

    fun getMovieList() {
        tvShowList.value = loadFromAsset().results as List<TvItem>?
    }

    private fun loadFromAsset(): TvResponse {
        val json: String
        lateinit var jsonModel: TvResponse
        try {
            val inputStream: InputStream? = context?.assets?.open("tvshow.json")
            json = inputStream?.bufferedReader().use { it?.readText().toString() }

            val gson = Gson()
            jsonModel = gson.fromJson(json, TvResponse::class.java)

        } catch (e: IOException) {

        }
        return jsonModel


    }
}