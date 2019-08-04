package id.qibee.moviejetpack

import androidx.recyclerview.widget.DiffUtil
import id.qibee.moviejetpack.model.MovieItem
import id.qibee.moviejetpack.model.TvItem

class TvDiffCallback(
    private val old: List<TvItem>,
    private val new: List<TvItem>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].name == new[newItemPosition].name
    }

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}