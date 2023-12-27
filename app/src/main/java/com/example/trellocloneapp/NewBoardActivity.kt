package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.NavUtils
import androidx.drawerlayout.widget.DrawerLayout
import com.example.trellocloneapp.adapters.ColorPickerAdapter
import com.example.trellocloneapp.models.BoardModel
import com.example.trellocloneapp.models.LabelModel
import com.example.trellocloneapp.models.TaskModel
import kotlin.random.Random

class NewBoardActivity : AppCompatActivity() {

    private var currentColor: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_board)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //color picker
        val colorList = listOf(R.color.brdColor1, R.color.brdColor2, R.color.brdColor3, R.color.brdColor4, R.color.brdColor5)
        val colorPicker = findViewById<Spinner>(R.id.colorPickSpinner)
        currentColor = colorList[0]
        colorPicker.adapter = ColorPickerAdapter(colorList)
        colorPicker.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentColor = colorList[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //Cancel button func
        val cancelBtn = findViewById<Button>(R.id.cancelButton)
        cancelBtn.setOnClickListener{ cancelButtonPressed() }

        //Create button func
        val createBtn = findViewById<Button>(R.id.createButton)
        createBtn.setOnClickListener{ createNewBoard() }
    }

    private fun cancelButtonPressed() {
        when (intent.extras?.getString("previous")) {
            "main" -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            "boards" -> {
                intent = Intent(this, BoardsListActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun createNewBoard() {
        val bNameEdt = findViewById<EditText>(R.id.boardNameEditText)
        if (bNameEdt.text?.toString() != "") {
            val brdName = bNameEdt.text.toString()
            var brdId = Random.nextInt()
            while (MainActivity.boardList.find { it.id == brdId } != null) {
                brdId = Random.nextInt()
            }
            val board = BoardModel(
                name = brdName,
                color = currentColor!!,
                tasks = mutableListOf<TaskModel>(),
                id = brdId,
                labels = mutableListOf<LabelModel>()
            )
            MainActivity.mostRecentBoard = board
            MainActivity.boardList.add(board)

            //Open newly created board
            intent = Intent(this, BoardActivity::class.java)
            intent.putExtra("boardName", board.name)
            intent.putExtra("previous", "boards")
            intent.putExtra("boardId", board.id)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "You must enter a board name!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (intent.extras?.getString("previous")) {
            "main" -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            "boards" -> {
                intent = Intent(this, BoardsListActivity::class.java)
                startActivity(intent)
            }
        }
        return true
        //return super.onOptionsItemSelected(item)
    }

    private fun openBoard(board: BoardModel) {
        intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("boardName", board.name)
        intent.putExtra("previous", "boards")
        intent.putExtra("boardId", board.id)
        startActivity(intent)
    }
}