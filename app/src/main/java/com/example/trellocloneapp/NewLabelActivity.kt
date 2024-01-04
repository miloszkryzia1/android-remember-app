package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.LabelColorAdapter
import com.example.trellocloneapp.models.BoardModel
import com.example.trellocloneapp.models.LabelModel

class NewLabelActivity : AppCompatActivity() {

    var board: BoardModel? = null
    var selectedColor: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        setColors(board!!.color)

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

        //cancel btn func
        val cancelBtn = findViewById<Button>(R.id.cancelButton)
        cancelBtn.setOnClickListener {
            val brdId = board!!.id
            val previous = intent.extras?.getString("previous")
            intent = Intent(this, LabelListActivity::class.java)
            intent.putExtra("boardId", brdId)
            intent.putExtra("previous", previous)
            startActivity(intent)
        }

        //create btn func
        val createBtn = findViewById<Button>(R.id.createButton)
        createBtn.setOnClickListener {
            val name = findViewById<EditText>(R.id.lblNameEdtTxt)
            var color = (recView.adapter as LabelColorAdapter).selectedColor
            if (name.text.toString() == "") {
                Toast.makeText(this, "You must enter a label name!", Toast.LENGTH_SHORT).show()
            }
            else {
                if (color == null) { color = R.color.lblColor1 }
                board!!.labels.add(LabelModel(name.text.toString(), color))
                val brdId = board!!.id
                val previous = intent.extras?.getString("previous")
                intent = Intent(this, LabelListActivity::class.java)
                intent.putExtra("boardId", brdId)
                intent.putExtra("previous", previous)
                startActivity(intent)
            }
        }
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