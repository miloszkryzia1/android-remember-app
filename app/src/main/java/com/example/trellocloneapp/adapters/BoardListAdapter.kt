package com.example.trellocloneapp.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.BoardActivity
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.BoardModel

class BoardListAdapter(var items: List<BoardModel>): Adapter<BoardListAdapter.BoardViewHolder>() {

    inner class BoardViewHolder(itemView: View): ViewHolder(itemView) {
        var name: TextView
        var colorImg: ImageView
        init {
            name = itemView.findViewById(R.id.boardName)
            colorImg = itemView.findViewById(R.id.colorImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_board, parent, false)
        return BoardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.name.text = items[position].name
        when (items[position].color) {
            R.color.brdColor1 -> holder.colorImg.setImageResource(R.drawable.brd_color_shape_1)
            R.color.brdColor2 -> holder.colorImg.setImageResource(R.drawable.brd_color_shape_2)
            R.color.brdColor3 -> holder.colorImg.setImageResource(R.drawable.brd_color_shape_3)
            R.color.brdColor4 -> holder.colorImg.setImageResource(R.drawable.brd_color_shape_4)
            R.color.brdColor5 -> holder.colorImg.setImageResource(R.drawable.brd_color_shape_5)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BoardActivity::class.java)
            intent.putExtra("boardName", items[position].name)
            intent.putExtra("previous", "boards")
            intent.putExtra("boardId", items[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }

}