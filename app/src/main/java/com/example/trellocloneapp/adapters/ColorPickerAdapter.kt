package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.trellocloneapp.R

class ColorPickerAdapter(private var items: List<Int>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.color_picker_item, parent, false)
        }
        else {
            view = convertView
        }

        val colorImg = view.findViewById<ImageView>(R.id.colorImg)
        when (items[position]) {
            R.color.brdColor1 -> colorImg.setImageResource(R.drawable.brd_color_shape_1)
            R.color.brdColor2 -> colorImg.setImageResource(R.drawable.brd_color_shape_2)
            R.color.brdColor3 -> colorImg.setImageResource(R.drawable.brd_color_shape_3)
            R.color.brdColor4 -> colorImg.setImageResource(R.drawable.brd_color_shape_4)
            R.color.brdColor5 -> colorImg.setImageResource(R.drawable.brd_color_shape_5)
        }

        return view
    }

}