package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.BoardActivity
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.TaskModel

class TaskListAdapter(var items: MutableList<TaskModel>): Adapter<TaskListAdapter.TaskViewHolder>() {

    var selectedItemPosition = -1
    inner class TaskViewHolder(itemView: View): ViewHolder(itemView) {
        //TODO: ADD THE REST OF PARAMS
        val txtName: TextView?
        val txtDesc: TextView?
        init {
            txtName = itemView.findViewById(R.id.taskNameTxt)
            txtDesc = itemView.findViewById(R.id.taskDescTxt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.txtName?.text = items[position].name
        var desc = items[position].description
        if (desc.length > 30) {
            desc = desc.substring(0, 31)
            desc += "..."
        }
        holder.txtDesc?.text = desc
        holder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
            selectedItemPosition = position
            val mi = MenuInflater(v.context)
            mi.inflate(R.menu.task_context_menu, menu)
        }
        //TODO: ADD THE REST OF PARAMS
    }

}