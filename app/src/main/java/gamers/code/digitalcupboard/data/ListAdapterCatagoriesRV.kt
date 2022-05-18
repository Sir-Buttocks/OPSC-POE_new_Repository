package gamers.code.digitalcupboard.data

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import gamers.code.digitalcupboard.R
import gamers.code.digitalcupboard.data.model.CategoriesModel
import kotlinx.android.synthetic.main.catagories_layout.view.*

class ListAdapterCatagoriesRV(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoriesModel>() {

        override fun areItemsTheSame(oldItem: CategoriesModel, newItem: CategoriesModel): Boolean {
            return oldItem.primaryKey == newItem.primaryKey
        }

        override fun areContentsTheSame(
            oldItem: CategoriesModel,
            newItem: CategoriesModel
        ): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return CatagoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.catagories_layout,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CatagoriesViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<CategoriesModel>) {
        differ.submitList(list)
    }

    class CatagoriesViewHolder
    constructor(itemView: View, private val interaction: Interaction?) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: CategoriesModel) {

            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.txtItemTitle.text = item.CategoryName+" - "+item.owner

            val progressbar = itemView.progressBar
            progressbar.max = item.max
            progressbar.progress = item.current

            itemView.imageView?.setImageDrawable(item.image)
            itemView.txtItemDate.text = item.current.toString()+"/"+item.max.toString()
        }
    }

    interface Interaction { //on click
        fun onItemSelected(position: Int, item: CategoriesModel)
    }
}