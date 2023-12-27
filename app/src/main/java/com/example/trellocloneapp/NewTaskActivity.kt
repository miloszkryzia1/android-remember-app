package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.trellocloneapp.models.BoardModel

class NewTaskActivity : AppCompatActivity() {

    var board: BoardModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO: ADD ALL LOGIC

        //GET BOARD
        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        //cancel button func
        val cancelBtn = findViewById<Button>(R.id.cancelButton)
        cancelBtn.setOnClickListener{
            intent = Intent(this, BoardActivity::class.java)
            intent.putExtra("boardId", board?.id)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("boardId", board?.id)
        startActivity(intent)
        return true
    }
}