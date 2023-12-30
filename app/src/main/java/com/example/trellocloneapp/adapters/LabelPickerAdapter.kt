package com.example.trellocloneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.trellocloneapp.R
import com.example.trellocloneapp.models.LabelModel

class LabelPickerAdapter(var items: List<LabelModel>): BaseAdapter() {
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
            view = LayoutInflater.from(parent?.context).inflate(R.layout.label_list_item, parent, false)
        }
        else {
            view = convertView
        }
        view.findViewById<TextView>(R.id.lblNameTxtView)?.text = items[position].name
        val img = view.findViewById<ImageView>(R.id.lblColorImg)
        when (items[position].color) {
            R.color.lblColor1 -> { img?.setImageResource(R.drawable.label_color_shape1) }
            R.color.lblColor2 -> { img?.setImageResource(R.drawable.label_color_shape2) }
            R.color.lblColor3 -> { img?.setImageResource(R.drawable.label_color_shape3) }
            R.color.lblColor4 -> { img?.setImageResource(R.drawable.label_color_shape4) }
            R.color.lblColor5 -> { img?.setImageResource(R.drawable.label_color_shape5) }
            R.color.lblColor6 -> { img?.setImageResource(R.drawable.label_color_shape6) }
        }
        return view
    }
}