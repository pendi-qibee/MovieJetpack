package id.qibee.moviejetpack.model

object DataDummy {

    fun addDummyMovie() : List<MovieItem>{
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