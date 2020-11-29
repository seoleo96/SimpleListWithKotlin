package com.seoleo96.retrolist.adapter

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seoleo96.retrolist.Main2Activity
import com.seoleo96.retrolist.R
import com.seoleo96.retrolist.model.Teacher
import kotlinx.android.synthetic.main.row_teacher.view.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class Adapter(val teacherlist : List<Teacher>?) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view  = layoutInflater.inflate(R.layout.row_teacher, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.itemView
        item.textView.text = teacherlist?.get(position)?.name
        Glide.with(item.context).asBitmap().load(teacherlist?.get(position)?.img).into(item.circleImageView)

        holder.itemView.setOnClickListener {
            sleep(2000)
            Toast.makeText(holder.itemView.context, teacherlist?.get(position)?.name.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, Main2Activity::class.java)
            intent.putExtra("name", teacherlist?.get(position)?.name)
            intent.putExtra("img", teacherlist?.get(position)?.img)
            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return teacherlist?.size!!
    }
}