package com.example.politravel.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.datamodel.Json
import com.example.politravel.datamodel.Paquet
import com.example.politravel.adapters.PaquetsAdapter
import com.example.politravel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class PackageListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_list)

        val paquetsList = findViewById<ListView>(R.id.list_paquet)

        val intent = intent.extras
        val language = intent?.getString(MainActivity.languageConstants.LANGUAGE)
        var paquets: MutableList<Paquet> = paquetsLanguage(language)

        val adapter = PaquetsAdapter(this, R.layout.package_item, paquets)
        paquetsList.adapter = adapter

        paquetsList.onItemClickListener = AdapterView.OnItemClickListener()
        {
                _, _, i, _ ->
            val intent = Intent(this, PackageDetailActivity::class.java)
            intent.putExtra(PackageDetailActivity.paquetConstants.PAQUET, paquets[i])
            startActivity(intent)
        }

        val add = findViewById<FloatingActionButton>(R.id.add)
        add.setOnClickListener{
            val intent = Intent(this, PackageAddActivity::class.java)
            startActivity(intent)
        }


    }

    fun paquetsLanguage(language: String?): MutableList<Paquet>{
        var list: MutableList<Paquet>

        val locale: String = Locale.getDefault().getDisplayName()
        if(locale.equals(MainActivity.languageConstants.CATALAN)){
            list = Json.getPaquets(this, Json.jsonNames.CATALAN)
        }else if(locale.equals(MainActivity.languageConstants.SPANISH)){
            list = Json.getPaquets(this, Json.jsonNames.SPANISH)
        }else{
            list = Json.getPaquets(this, Json.jsonNames.ENGLISH)
        }

        return list
    }
}