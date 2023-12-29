package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.LabelColorAdapter
import com.example.trellocloneapp.models.BoardModel

class NewLabelActivity : AppCompatActivity() {

    var board: BoardModel? = null
    var selectedColor: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        setContentView(R.layout.activity_new_label)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //Recycler view
        val recView = findViewById<RecyclerView>(R.id.lblColorRecView)
        recView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        val colorList = listOf(
            R.color.lblColor1,
            R.color.lblColor2,
            R.color.lblColor3,
            R.color.lblColor4,
            R.color.lblColor5,
            R.color.lblColor6
        )
        recView.adapter = LabelColorAdapter(colorList)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val brdId = board!!.id
        val previous = intent.extras?.getString("previous")
        intent = Intent(this, LabelListActivity::class.java)
        intent.putExtra("boardId", brdId)
        intent.putExtra("previous", previous)
        startActivity(intent)
        return true
    }
}