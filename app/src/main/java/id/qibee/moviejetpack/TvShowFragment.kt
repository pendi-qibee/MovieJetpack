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
import id.qibee.moviejetpack.databinding.FragmentTvShowBinding
import id.qibee.moviejetpack.model.TvItem

class TvShowFragment : Fragment() {

    private var movieList: List<TvItem> = arrayListOf()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val clickListener: TvClickListener = this::onTvItemClicked
    private val mAdapter = TvShowRvAdapter(clickListener)
    private lateinit var viewModel: TvShowViewModel

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
            .apply { lifecycleOwner = this@TvShowFragment }

        linearLayoutManager = LinearLayoutManager(context)
        binding.rvTvShow.layoutManager = linearLayoutManager
        binding.rvTvShow.adapter = mAdapter

        viewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
        viewModel.observableTvList.observe(this, Observer { resultItem ->
            resultItem?.let {
                movieList = resultItem

                mAdapter.updateTvShow(movieList)
            }
        })


        return binding.root
    }


    private fun onTvItemClicked(tvShow: TvItem) {

        val directions = TvShowFragmentDirections.actionTvShowFragmentToTvShowDetailFragment(tvShow)
        view.let { findNavController().navigate(directions) }

    }


}
