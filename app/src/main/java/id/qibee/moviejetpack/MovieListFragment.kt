package id.qibee.moviejetpack


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.qibee.moviejetpack.databinding.FragmentMovieListBinding
import id.qibee.moviejetpack.model.MovieItem

class MovieListFragment : Fragment() {
    private var movieList: List<MovieItem> = arrayListOf()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val clickListener: ClickListener = this::onItemClicked
    private val mAdapter = MovieRvAdapter(clickListener)
    private lateinit var viewModel: MovieListViewModel

    private lateinit var binding: FragmentMovieListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
            .apply { lifecycleOwner = this@MovieListFragment }

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
        viewModel.getMovieList()
        viewModel.observableMovieList.observe(this, Observer { resultItem ->
            resultItem?.let {
                movieList = resultItem
                linearLayoutManager = LinearLayoutManager(context)
                binding.rvMovie.layoutManager = linearLayoutManager
                binding.rvMovie.adapter = mAdapter

                mAdapter.updateMovies(movieList)
            }
        })


        return binding.root
    }

    private fun onItemClicked(movie: MovieItem) {

        val directions = MovieListFragmentDirections.actionMovieListToDetail(movie)
        view.let { findNavController().navigate(directions) }
    }

}
