package com.example.kotlin1lesson4.ui.playlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1lesson4.R
import com.example.kotlin1lesson4.model.playlist.Items
import kotlinx.android.synthetic.main.playlist_list.view.*

class PlayListsAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<PlayListsAdapter.PlayListViewHolder>() {

    private var items: List<Items> = ArrayList()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_list, parent, false)
        return PlayListViewHolder(itemView, context as Context)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(list : List<Items>) {
        items = list
        notifyDataSetChanged()
    }

    inner class PlayListViewHolder(itemView: View, context: Context)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bind(items: Items) {
            itemView.txt_pl_list_name.text = items.snippet.title
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val pos : Int = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                listener.onClick(items[pos])
            }
        }
    }
}

interface OnItemClickListener {
    fun onClick(items: Items)
}