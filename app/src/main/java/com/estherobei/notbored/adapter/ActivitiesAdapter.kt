package com.estherobei.notbored.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estherobei.notbored.R
import com.estherobei.notbored.databinding.SingleActivityBinding
import com.estherobei.notbored.model.Activity

class ActivitiesAdapter(var activitiesList: List<Activity>, val clickListener: ClickListener) :
    RecyclerView.Adapter<ActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_activity, parent, false)
        return ActivityViewHolder(view, this.clickListener)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activitiesList[position])
    }

    override fun getItemCount(): Int {
        return activitiesList.size
    }
}

class ActivityViewHolder(view: View, clickListener: ClickListener) : RecyclerView.ViewHolder(view) {
    private val binding = SingleActivityBinding.bind(view)
    val name = binding.textView2
    fun bind(activity: Activity) {
        name.text = activity.title
    }
    init {
        binding.imBtnNext.setOnClickListener {
            clickListener.onItemClick(adapterPosition)
        }
    }
}

interface ClickListener {
    fun onItemClick(position: Int)
}
