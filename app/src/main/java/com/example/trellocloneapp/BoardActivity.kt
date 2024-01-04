package com.example.trellocloneapp

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.TaskListAdapter
import com.example.trellocloneapp.models.BoardModel
import com.example.trellocloneapp.models.LabelModel
import com.example.trellocloneapp.models.TaskModel

class BoardActivity : AppCompatActivity() {

    var board: BoardModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Get board reference
        board = MainActivity.boardList.find { it.id == intent.extras?.getInt("boardId") }
        MainActivity.mostRecentBoard = board

        //set action bar colors
        setColors(board!!.color)

        setContentView(R.layout.activity_board)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //set board name
        val nameTxtView = findViewById<TextView>(R.id.name)
        nameTxtView.text = board!!.name

        //Get board's task list
        val taskList = board!!.tasks

        //Button func
        val btn = findViewById<Button>(R.id.addTaskButton)
        btn.setOnClickListener {
            val previous = intent.extras?.getString("previous")
            intent = Intent(this, NewTaskActivity::class.java)
            intent.putExtra("boardId", board!!.id) //pass board ID to then retrieve label list
            intent.putExtra("previous", previous)
            startActivity(intent)
        }

        val recView = findViewById<RecyclerView>(R.id.tasksRecView)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = TaskListAdapter(board!!.tasks)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.editLblsItem) {
            val previous = intent.extras?.getString("previous")
            intent = Intent(this, LabelListActivity::class.java)
            intent.putExtra("boardId", board!!.id) //pass board ID to then retrieve label list
            intent.putExtra("previous", previous)
            startActivity(intent)
            return true
        }
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_labels_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val recView = findViewById<RecyclerView>(R.id.tasksRecView)
        val adapter = recView.adapter as TaskListAdapter
        val itemPosition = adapter.selectedItemPosition
        if (item.itemId == R.id.actionCompleteTask) {
            adapter.items[itemPosition].completed = true
            adapter.notifyItemChanged(itemPosition)
        }
        else if (item.itemId == R.id.actionUncompleteTask) {
            adapter.items[itemPosition].completed = false
            adapter.notifyItemChanged(itemPosition)
        }
        else if (item.itemId == R.id.actionRemoveTask) {
            adapter.items.removeAt(itemPosition)
            adapter.notifyItemRemoved(itemPosition)
        }
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