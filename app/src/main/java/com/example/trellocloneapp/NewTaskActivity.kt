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

        //GET BOARD
        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        //set colors
        setColors(board!!.color)

        setContentView(R.layout.activity_new_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO: ADD ALL LOGIC AND LABEL SELECTOR



        //cancel button func
        val cancelBtn = findViewById<Button>(R.id.cancelButton)
        cancelBtn.setOnClickListener{
            val previous = intent.extras?.getString("previous")
            intent = Intent(this, BoardActivity::class.java)
            intent.putExtra("boardId", board?.id)
            intent.putExtra("previous", previous)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val previous = intent.extras?.getString("previous")
        intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("boardId", board?.id)
        intent.putExtra("previous", previous)
        startActivity(intent)
        return true
    }
    private fun setColors(color: Int) {
        when (color) {
            R.color.brdColor1 ->{
                setTheme(R.style.BoardPageTheme1)
            }
            R.color.brdColor2 ->{
                setTheme(R.style.BoardPageTheme2)
            }
            R.color.brdColor3 ->{
                setTheme(R.style.BoardPageTheme3)
            }
            R.color.brdColor4 ->{
                setTheme(R.style.BoardPageTheme4)
            }
            R.color.brdColor5 ->{
                setTheme(R.style.BoardPageTheme5)
            }
        }
    }

}