package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trellocloneapp.R

class LabelColorAdapter(var items: List<Int>): Adapter<LabelColorAdapter.ColorViewHolder>() {

    var selectedColor: Int? = null

    inner class ColorViewHolder(itemView: View): ViewHolder(itemView) {
        var img: ImageView?
        init {
            img = itemView.findViewById(R.id.lblColorIcon)
            itemView.setOnClickListener{
                notifyItemChanged(items.indexOf(selectedColor))
                selectedColor = items[adapterPosition]
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.label_color_icon, parent, false)
        return ColorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        if (selectedColor != items[position]) {
            when (items[position]) {
                R.color.lblColor1 -> { holder.img?.setImageResource(R.drawable.label_color_shape1) }
                R.color.lblColor2 -> { holder.img?.setImageResource(R.drawable.label_color_shape2) }
                R.color.lblColor3 -> { holder.img?.setImageResource(R.drawable.label_color_shape3) }
                R.color.lblColor4 -> { holder.img?.setImageResource(R.drawable.label_color_shape4) }
                R.color.lblColor5 -> { holder.img?.setImageResource(R.drawable.label_color_shape5) }
                R.color.lblColor6 -> { holder.img?.setImageResource(R.drawable.label_color_shape6) }
            }
        }
        else {
            when (items[position]) {
                R.color.lblColor1 -> { holder.img?.setImageResource(R.drawable.label_color_shape_1_sel) }
                R.color.lblColor2 -> { holder.img?.setImageResource(R.drawable.label_color_shape_2_sel) }
                R.color.lblColor3 -> { holder.img?.setImageResource(R.drawable.label_color_shape_3_sel) }
                R.color.lblColor4 -> { holder.img?.setImageResource(R.drawable.label_color_shape_4_sel) }
                R.color.lblColor5 -> { holder.img?.setImageResource(R.drawable.label_color_shape_5_sel) }
                R.color.lblColor6 -> { holder.img?.setImageResource(R.drawable.label_color_shape_6_sel) }
            }
        }
    }

}