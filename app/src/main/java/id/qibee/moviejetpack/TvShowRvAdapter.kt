package id.qibee.moviejetpack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.qibee.moviejetpack.model.TvItem

typealias TvClickListener = (TvItem) -> Unit

class TvShowRvAdapter(private val clickListener: TvClickListener) : RecyclerView.Adapter<TvShowRvAdapter.ViewHolder>() {
    private var tvShowList = emptyList<TvItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false) as ViewGroup
        val viewHolder = ViewHolder(itemContainer)
        itemContainer.setOnClickListener {
            clickListener(tvShowList[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tvItem: TvItem = tvShowList[position]

        with(tvItem) {
            holder.title.text = name
            holder.overview.text = overview
            Picasso.get().load("file:///android_asset/tvshows$posterPath").into(holder.poster)
        }
    }

    override fun getItemCount(): Int = tvShowList.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val overview: TextView = view.findViewById(R.id.textOverview)
        val poster: ImageView = view.findViewById(R.id.thumbnail)

    }

    fun updateTvShow(tvList: List<TvItem>) {
        val diffResult = calculateDiff(TvDiffCallback(this.tvShowList, tvList))
        this.tvShowList = tvList
        diffResult.dispatchUpdatesTo(this)
    }
}