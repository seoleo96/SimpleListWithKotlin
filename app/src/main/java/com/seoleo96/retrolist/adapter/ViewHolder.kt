package com.seoleo96.retrolist.adapter

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seoleo96.retrolist.Main2Activity
import com.seoleo96.retrolist.model.Teacher
import kotlinx.android.synthetic.main.row_teacher.view.*

open class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
{
    fun bind(teacherlist: Teacher) {
        itemView.textView.text = teacherlist?.name
        Glide.with(itemView.context).asBitmap().load(teacherlist?.img).into(itemView.circleImageView)

        itemView.setOnClickListener {
            Thread.sleep(1000)
            Toast.makeText(itemView.context, teacherlist?.name.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(itemView.context, Main2Activity::class.java)
            intent.putExtra("name", teacherlist?.name)
            intent.putExtra("img", teacherlist?.img)
            itemView.context.startActivity(intent)
        }
    }
}