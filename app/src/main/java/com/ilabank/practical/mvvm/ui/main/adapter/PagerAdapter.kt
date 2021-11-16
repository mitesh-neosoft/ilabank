package com.ilabank.practical.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.practical.mvvm.R
import com.ilabank.practical.mvvm.data.model.Animal
import kotlinx.android.synthetic.main.pager_item_layout.view.*

class PagerAdapter(
    private val users: ArrayList<Animal>,
) : RecyclerView.Adapter<PagerAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Animal) {
            itemView.imgView.setImageResource(article.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pager_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<Animal>) {
        users.addAll(list)
    }

    fun getData(position: Int):String {
        return users[position].title
    }

    interface clickListener {
        fun click(data: Animal)
    }
}