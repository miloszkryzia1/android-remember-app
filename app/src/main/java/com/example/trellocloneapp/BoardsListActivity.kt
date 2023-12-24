package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.BoardListAdapter

class BoardsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardslist)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recycler view
        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = BoardListAdapter(MainActivity.boardList)

        //button func
        val btn = findViewById<Button>(R.id.addTaskButton)
        btn.setOnClickListener{ openNewBoardScreen() }
    }

    private fun openNewBoardScreen() {
        intent = Intent(this, NewBoardActivity::class.java)
        intent.putExtra("previous", "boards")
        startActivity(intent)
    }

}