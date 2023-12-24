package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.TaskModel

class TaskListAdapter(private var items: List<TaskModel>): Adapter<TaskListAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View): ViewHolder(itemView) {
        //TODO: ADD THE REST OF PARAMS
        val txt: TextView?
        init {
            txt = itemView.findViewById(R.id.taskNameTxt)
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
        holder.txt?.text = items[position].name
        //TODO: ADD THE REST OF PARAMS
    }

}