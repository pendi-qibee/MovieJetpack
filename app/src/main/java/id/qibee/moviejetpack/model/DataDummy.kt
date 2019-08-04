package id.qibee.moviejetpack.model

import android.util.Log
import androidx.lifecycle.LiveData
import kotlin.math.absoluteValue

object DataDummy {


/*
open fun addDummyMovie() : MutableList<MovieItem>{
        var movieItem1 = MovieItem("overview1",
            "en",
            "Batman",
            true,
            "Fake Batman",
            null,
            "path/path",
            "pathlagi/pathlagi",
            "12-12-12",
            7.8,
            4.7,
            2,
            true,
            1001)
        var movieItem2 = MovieItem("overview1",
            "en",
            "Batman",
            true,
            "Fake Batman",
            null,
            "path/path",
            "pathlagi/pathlagi",
            "12-12-12",
            7.8,
            4.7,
            2,
            true,
            1001)

        movieList.add(movieItem1)
        movieList.add(movieItem2)

        return movieList
    }
*/
open fun addDummyMovie() : List<MovieItem>{
        return listOf( MovieItem("overview1",
            "en",
            "Batman",
            true,
            "Fake Batman",
            null,
            "path/path",
            "pathlagi/pathlagi",
            "12-12-12",
            7.8,
            4.7,
            2,
            true,
            1001),
        MovieItem("overview1",
            "en",
            "Batman",
            true,
            "Fake Batman",
            null,
            "path/path",
            "pathlagi/pathlagi",
            "12-12-12",
            7.8,
            4.7,
            2,
            true,
            1001)
        )

    }

}