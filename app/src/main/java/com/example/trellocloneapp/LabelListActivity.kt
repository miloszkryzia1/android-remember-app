package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        //TODO: TEMP LIST FOR TESTING
        val labelList = listOf(
            LabelModel("Label 1", R.color.lblColor1),
            LabelModel("Label 2", R.color.lblColor2),
            LabelModel("Label 3", R.color.lblColor3),
            LabelModel("Label 4", R.color.lblColor4),
            LabelModel("Label 5", R.color.lblColor5),
            LabelModel("Label 6", R.color.lblColor6),
        )
        recView.adapter = LabelListAdapter(labelList)

        //btn func
        val btn = findViewById<Button>(R.id.addLabelButton)
        btn.setOnClickListener{
            intent = Intent(this, NewLabelActivity::class.java)
            intent.putExtra("boardId", board!!.id)
            intent.putExtra("previous", intent.extras?.getString("previous"))
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