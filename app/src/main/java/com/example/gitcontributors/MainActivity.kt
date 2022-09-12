package com.example.gitcontributors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val vmInstance = ViewModelProvider(this)[ContributorViewModel::class.java]
        Log.i("MyTag", "Load contributors")
        vmInstance.getContributorsFromObserver()
            .observe(this,Observer<List<ContributorItem>>{
                Log.i("MyTag", "View Model data: ${it.size}")
                recyclerView.adapter = ContributorAdapter(it)
            })
    }
}
