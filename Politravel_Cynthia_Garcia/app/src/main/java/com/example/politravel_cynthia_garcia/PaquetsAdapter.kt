package com.example.politravel_cynthia_garcia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

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
        //TODO: 10 Llistes personalitzades 18:40
    }
}