package com.seoleo96.retrolist.api

import com.seoleo96.retrolist.model.Teacher
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

    @GET("api/characters")
    fun getTeachers() : Call<List<Teacher>>
}