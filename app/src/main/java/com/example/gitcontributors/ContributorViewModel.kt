package com.example.gitcontributors

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitcontributors.network.ContributorsBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContributorViewModel : ViewModel(){

    var contributorList = MutableLiveData<List<ContributorItem>>()

    init {
        loadContributors()
    }

    fun getContributorsFromObserver(): LiveData<List<ContributorItem>> {
        return contributorList
    }

    private fun loadContributors() {

        ContributorsBuilder.getContributors(object : Callback<List<ContributorItem>> {
            override fun onResponse(
                call: Call<List<ContributorItem>>,
                response: Response<List<ContributorItem>>
            ) {
                contributorList.value = response.body()
                Log.i("MyTag", "On response viewModel")
            }

            override fun onFailure(call: Call<List<ContributorItem>>, t: Throwable) {
                Log.e("ERROR", "Error in response: " + t.message)
            }
        })
    }
}