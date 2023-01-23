package com.example.politravel.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ItineraryListEditAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_list_edit_add)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent
        val itinerary: ArrayList<String> =
            intent.getStringArrayListExtra(ItineraryListActivity.itineraryConstants.ITINERARY)
                    as ArrayList<String>
    //----------------------------------------------------------------------------------------------

    //----Show the data-----------------------------------------------------------------------------
        var itineraryList = findViewById<ListView>(R.id.list_itinerary_add)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itinerary)
        itineraryList.adapter = adapter
    //----------------------------------------------------------------------------------------------

        itineraryList.onItemClickListener = AdapterView.OnItemClickListener()
        {
                _, _, i, _ ->
            val intent = Intent(this, PackageDetailActivity::class.java)
            intent.putExtra(ItineraryDetailEditActivity.itineraryConstants.ITINERARY, itinerary[i])
            startActivity(intent)
        }

        val add = findViewById<FloatingActionButton>(R.id.add_itinerary)
        add.setOnClickListener{
            val intent = Intent(this, ItineraryDetailAddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, getString(R.string.edit_itinerary), Toast.LENGTH_LONG).show()
    }
}