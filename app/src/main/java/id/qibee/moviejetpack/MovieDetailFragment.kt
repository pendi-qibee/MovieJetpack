package id.qibee.moviejetpack


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import id.qibee.moviejetpack.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val safeArgs: MovieDetailFragmentArgs by navArgs()
        val movie = safeArgs.movie

        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
            .apply { lifecycleOwner = this@MovieDetailFragment }


        binding.textTitle.text = movie.title
        binding.textOverview.text = movie.overview
        binding.textRating.text = "${movie.voteAverage}"
        binding.textReleaseDate.text = movie.releaseDate

        Picasso.get().load("file:///android_asset/movies${movie.posterPath}").into(binding.imagePoster)

        return binding.root
    }


}
