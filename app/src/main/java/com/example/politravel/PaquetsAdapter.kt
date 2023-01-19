package com.example.politravel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PaquetsAdapter(context: Context, val layout: Int, val paquets: MutableList<Paquet>):
    ArrayAdapter<Paquet>(context, layout, paquets) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View

        if(convertView != null){
            view = convertView
        }else{
            view = LayoutInflater.from(context).inflate(layout, parent, false)
        }
        bindPaquet(view, paquets[position])

        return view
    }

    fun bindPaquet(view: View, paquet: Paquet){
        val imgPaquet = view.findViewById<ImageView>(R.id.item_img_paquet)
        imgPaquet.setImageResource(paquet.imgLow)

        val paquetName = view.findViewById<TextView>(R.id.item_name)
        paquetName.text = paquet.name

        val transport = view.findViewById<TextView>(R.id.item_img_transport)
        transport.text = paquet.transport

        val days = view.findViewById<TextView>(R.id.item_days)
        days.text = paquet.days.toString()
    }
}