package com.example.gitcontributors.network

import com.example.gitcontributors.ContributorItem
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ContributorsBuilder {

    companion object {
        // Base URL
        private const val url = "https://github.com/Hiteja/PracticeApp/graphs/"
        private val gsonConverter = GsonConverterFactory.create()

        fun getContributors(callback: Callback<List<ContributorItem>>) {
            // Create retrofit service builder
            val network = Retrofit.Builder().baseUrl(url)
                .addConverterFactory(gsonConverter)
                .build()

            // Create retrofit instance
            val service = network.create(ContributorInterface::class.java)
            val call = service.requestContributors()
            call.enqueue(callback)
        }
    }
}