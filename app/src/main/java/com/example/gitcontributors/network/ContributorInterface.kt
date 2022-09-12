package com.example.gitcontributors.network

import com.example.gitcontributors.ContributorItem
import retrofit2.Call
import retrofit2.http.GET

interface ContributorInterface {

    @GET("contributors")
    fun requestContributors() : Call<List<ContributorItem>>
}