package id.qibee.moviejetpack

import androidx.recyclerview.widget.DiffUtil
import id.qibee.moviejetpack.model.MovieItem

class MovieDiffCallback(
    private val old: List<MovieItem>,
    private val new: List<MovieItem>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].title == new[newItemPosition].title
    }

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}