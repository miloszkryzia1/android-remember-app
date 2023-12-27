package com.example.trellocloneapp

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.TaskListAdapter
import com.example.trellocloneapp.models.LabelModel
import com.example.trellocloneapp.models.TaskModel

class BoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Get board reference
        val board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }

        //set action bar colors
        setColors(board!!.color)

        setContentView(R.layout.activity_board)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //set board name
        val nameTxtView = findViewById<TextView>(R.id.name)
        nameTxtView.text = intent.extras?.getString("boardName")

        //Get board's task list
        val taskList = board.tasks

        //Button func
        val btn = findViewById<Button>(R.id.addTaskButton)
        btn.setOnClickListener {
            //TODO IMPLEMENT - ADD CREATE NEW TASK SCREEN
        }

        val recView = findViewById<RecyclerView>(R.id.tasksRecView)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //TODO: TEMP LIST FOR TESTING
        taskList.addAll(
            listOf(
                TaskModel("chuj" ,"chuj", LabelModel("testlabel", R.color.white)),
                TaskModel("chuj" ,"chuj", LabelModel("testlabel", R.color.white)),
                TaskModel("chuj" ,"chuj", LabelModel("testlabel", R.color.white)),
                TaskModel("chuj" ,"chuj", LabelModel("testlabel", R.color.white)))
        )

        recView.adapter = TaskListAdapter(taskList)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //TODO: ADD MENU TO EDIT LABELS

        intent = Intent(this, BoardsListActivity::class.java)
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