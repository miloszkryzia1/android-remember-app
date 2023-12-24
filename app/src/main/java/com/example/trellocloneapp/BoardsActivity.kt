package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.BoardListAdapter

class BoardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boards)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recycler view
        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = BoardListAdapter(MainActivity.boardList)

    }

}