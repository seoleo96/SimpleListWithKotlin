package com.seoleo96.retrolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.circleImageView
import kotlinx.android.synthetic.main.row_teacher.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent.extras
        val name = intent?.get("name")
        val img = intent?.get("img")

        Glide.with(this).load(img).centerCrop().into(circleImageView)
        name2.text = name.toString()
    }
}
