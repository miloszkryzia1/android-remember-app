package com.example.trellocloneapp.adapters

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.TaskModel

class TaskListAdapter(var items: MutableList<TaskModel>): Adapter<TaskListAdapter.TaskViewHolder>() {

    var selectedItemPosition = -1
    inner class TaskViewHolder(itemView: View): ViewHolder(itemView) {
        val txtName: TextView?
        val txtDesc: TextView?
        val colorCard: CardView?
        init {
            txtName = itemView.findViewById(R.id.taskNameTxt)
            txtDesc = itemView.findViewById(R.id.taskDescTxt)
            colorCard = itemView.findViewById(R.id.taskColorCard)
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
        if (!items[position].completed) {
            holder.txtName?.setTextColor(Color.WHITE)
            var desc = items[position].description
            if (desc.isEmpty()) {
                holder.txtDesc?.isVisible = false
            }
            else {
                if (desc.length > 30) {
                    desc = desc.substring(0, 31)
                    desc += "..."
                }
                holder.txtDesc?.text = desc
            }
            holder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
                selectedItemPosition = position
                val mi = MenuInflater(v.context)
                mi.inflate(R.menu.task_context_menu_uncomplete, menu)
            }
        }
        else {
            holder.txtName?.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.txtName?.setTextColor(Color.parseColor("#575757")) //main_bg color in resource
            holder.txtDesc?.isVisible = false
            holder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
                selectedItemPosition = position
                val mi = MenuInflater(v.context)
                mi.inflate(R.menu.task_context_menu_complete, menu)
            }
        }
        if (items[position].label != null) {
            val color = ContextCompat.getColor(holder.itemView.context, items[position].label!!.color)
            holder.colorCard?.setCardBackgroundColor(color)
        }
        else {
            holder.colorCard?.setCardBackgroundColor(Color.parseColor("#575757"))
        }
    }

}