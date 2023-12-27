package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.LabelModel

class LabelListAdapter(var items: List<LabelModel>): Adapter<LabelListAdapter.LabelViewHolder>() {

    inner class LabelViewHolder(itemView: View): ViewHolder(itemView) {
        var txt: TextView?
        var img: ImageView?
        init {
            txt = itemView.findViewById(R.id.lblNameTxtView)
            img = itemView.findViewById(R.id.lblColorImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.label_list_item, parent, false)
        return LabelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LabelViewHolder, position: Int) {
        holder.txt?.text = items[position].name
        when (items[position].color) {
            R.color.lblColor1 -> { holder.img?.setImageResource(R.drawable.label_color_shape1) }
            R.color.lblColor2 -> { holder.img?.setImageResource(R.drawable.label_color_shape2) }
            R.color.lblColor3 -> { holder.img?.setImageResource(R.drawable.label_color_shape3) }
            R.color.lblColor4 -> { holder.img?.setImageResource(R.drawable.label_color_shape4) }
            R.color.lblColor5 -> { holder.img?.setImageResource(R.drawable.label_color_shape5) }
            R.color.lblColor6 -> { holder.img?.setImageResource(R.drawable.label_color_shape6) }
        }
    }

}