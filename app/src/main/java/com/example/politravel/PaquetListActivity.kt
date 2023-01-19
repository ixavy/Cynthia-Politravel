package com.example.politravel

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class PaquetListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paquets_list)

        val paquetsList = findViewById<ListView>(R.id.list_paquet)

        val paquets: MutableList<Paquet> = Json.getPaquets(this)

        val adapter = PaquetsAdapter(this, R.layout.paquets_item, paquets)
        paquetsList.adapter = adapter

        paquetsList.onItemClickListener = AdapterView.OnItemClickListener()
        {
                _, _, i, _ ->
            val intent = Intent(this, PaquetDetailActivity::class.java)
            intent.putExtra(PaquetDetailActivity.paquetConstants.PAQUET, paquets[i])
            startActivity(intent)
        }
    }
}