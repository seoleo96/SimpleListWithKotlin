package com.seoleo96.retrolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seoleo96.retrolist.R
import com.seoleo96.retrolist.model.Teacher

class Adapter(val teacherlist : List<Teacher>?) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view  = layoutInflater.inflate(R.layout.row_teacher, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        teacherlist?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return teacherlist?.size!!
    }
}