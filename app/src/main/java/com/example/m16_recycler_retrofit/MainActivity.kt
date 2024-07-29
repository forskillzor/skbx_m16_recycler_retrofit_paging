package com.example.m16_recycler_retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.m16_recycler_retrofit.movielist.MovieListFragment
import com.example.m16_recycler_retrofit.pagedmovielist.MoviePagedListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace<MoviePagedListFragment>(R.id.container)
        }
    }
}