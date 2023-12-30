package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.LabelColorAdapter
import com.example.trellocloneapp.adapters.LabelListAdapter
import com.example.trellocloneapp.models.BoardModel
import com.example.trellocloneapp.models.LabelModel

class LabelListActivity : AppCompatActivity() {

    var board: BoardModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //get board
        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        //set colors
        setColors(board!!.color)

        setContentView(R.layout.activity_label_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //set board name
        val brdName = findViewById<TextView>(R.id.brdNameTxtView)
        brdName.text = board!!.name

        val recView = findViewById<RecyclerView>(R.id.recViewLabels)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = LabelListAdapter(board!!.labels)

        //btn func
        val btn = findViewById<Button>(R.id.addLabelButton)
        btn.setOnClickListener{
            val previous = intent.extras?.getString("previous")
            intent = Intent(this, NewLabelActivity::class.java)
            intent.putExtra("boardId", board!!.id)
            intent.putExtra("previous", previous)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val previous = intent.extras?.getString("previous")
        intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("boardId", board!!.id)
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