package id.qibee.moviejetpack


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import id.qibee.moviejetpack.databinding.FragmentTvShowDetailBinding

class TvShowDetailFragment : Fragment() {

    private lateinit var binding: FragmentTvShowDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val safeArgs: TvShowDetailFragmentArgs by navArgs()
        val tvShow = safeArgs.tvShow

        binding = FragmentTvShowDetailBinding.inflate(inflater, container, false)
            .apply { lifecycleOwner = this@TvShowDetailFragment }

        with(tvShow) {
            binding.textNameTv.text = name
            binding.textFirstairDate.text = firstAirDate
            binding.textOverview.text = overview
            binding.textVote.text = voteAverage.toString()

            Picasso.get().load("file:///android_asset/tvshows$posterPath").into(binding.imagePosterTv)
        }

        return binding.root
    }


}
