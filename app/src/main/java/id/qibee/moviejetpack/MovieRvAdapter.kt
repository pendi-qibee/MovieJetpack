package id.qibee.moviejetpack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.qibee.moviejetpack.model.MovieItem

typealias ClickListener = (MovieItem) -> Unit

class MovieRvAdapter(private val clickListener: ClickListener) : RecyclerView.Adapter<MovieRvAdapter.ViewHolder>() {
    private var movieList = emptyList<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false) as ViewGroup
        val viewHolder = ViewHolder(itemContainer)
        itemContainer.setOnClickListener {
            clickListener(movieList[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movieItem: MovieItem = movieList[position]

        with(movieItem) {
            holder.title.text = title
            holder.overview.text = overview
            Picasso.get().load("file:///android_asset/movies$posterPath").into(holder.poster)
        }
    }

    override fun getItemCount(): Int = movieList.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val overview: TextView = view.findViewById(R.id.textOverview)
        val poster: ImageView = view.findViewById(R.id.thumbnail)

    }

    fun updateMovies(movieList: List<MovieItem>) {
        val diffResult = calculateDiff(MovieDiffCallback(this.movieList, movieList))
        this.movieList = movieList
        diffResult.dispatchUpdatesTo(this)
    }
}