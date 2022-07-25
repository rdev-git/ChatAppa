package com.free.fast.date.flirt.meeting.app.plug.ui.list

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.ListFormItemBinding
import com.free.fast.date.flirt.meeting.app.plug.data.Girl

class ListFormAdapter(private val onClick: (Girl) -> Unit):
    ListAdapter<Girl, ListViewHolder>(ListViewHolder.CategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        ListFormItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ), onClick
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class ListViewHolder(
    private val itemBinding: ListFormItemBinding,
    onClick: (Girl) -> Unit
):
    RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var currentItem: Girl

    init {
        itemView.setOnClickListener {
            currentItem.let(onClick)
        }
    }

    fun bind(item: Girl) {
        currentItem = item
        itemBinding.name.text = item.name
        itemBinding.city.text = item.city

        Glide.with(itemView)
            .load(Uri.parse(item.avatar))
            .circleCrop()
            .placeholder(R.drawable.ic_baseline_cloud_off_24)
            .into(itemBinding.avatar)
    }

    object CategoryDiffCallback : DiffUtil.ItemCallback<Girl>() {
        override fun areItemsTheSame(oldItem: Girl, newItem: Girl): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Girl, newItem: Girl): Boolean {
            return oldItem.age== newItem.age
        }
    }

}