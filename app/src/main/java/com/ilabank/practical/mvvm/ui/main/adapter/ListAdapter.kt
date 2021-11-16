package com.ilabank.practical.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.practical.mvvm.R
import com.ilabank.practical.mvvm.data.model.Animal
import kotlinx.android.synthetic.main.list_item_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter(
    private val dataList: ArrayList<Animal>,
) : RecyclerView.Adapter<ListAdapter.DataViewHolder>(), Filterable {

    var filterList = ArrayList<Animal>()

    init {
        filterList = dataList
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Animal) {
            itemView.txtTitle.text = article.title
            itemView.imgView.setImageResource(article.image)

            itemView.setOnClickListener {
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = filterList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(filterList[position])

    fun addData(list: List<Animal>) {
        dataList.clear()
        dataList.addAll(list)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filterList = dataList
                } else {
                    val resultList = ArrayList<Animal>()
                    for (row in dataList) {
                        if (row.title.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<Animal>
                notifyDataSetChanged()
            }
        }
    }
}