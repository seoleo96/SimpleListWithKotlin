package com.seoleo96.retrolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.seoleo96.retrolist.adapter.Adapter
import com.seoleo96.retrolist.api.RetrofitInstance
import com.seoleo96.retrolist.model.Teacher
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val call = RetrofitInstance.api.getTeachers()

        var list: List<Teacher>
        call.enqueue(object : retrofit2.Callback<List<Teacher>> {
            override fun onResponse(call: Call<List<Teacher>>, response: Response<List<Teacher>>) {
                if (!response.isSuccessful) {
                    Log.d("Rezponse", response.message())
                    return
                }
                list = response.body()!!
                val adapter = Adapter(list)
                recyclerView.adapter = adapter
            }
            override fun onFailure(call: Call<List<Teacher>>, t: Throwable) {
                Log.d("Rezponse", t.message)
            }
        })

    }
}


