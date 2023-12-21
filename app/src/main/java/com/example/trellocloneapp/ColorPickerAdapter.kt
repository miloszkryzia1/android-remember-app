package com.example.trellocloneapp

import android.app.Activity
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ColorPickerAdapter(private var activity: Activity, private var items: List<Int>): BaseAdapter() {
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
            view = activity.layoutInflater.inflate(R.layout.color_picker_item, parent, false)
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