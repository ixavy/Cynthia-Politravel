package com.example.politravel.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R

/**
 * Places to visit in a package
 */
class ItineraryListActivity: AppCompatActivity() {
    object itineraryConstants{
        const val ITINERARY = "ITINERARY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_list)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent
        val itinerary: ArrayList<String> =
            intent.getStringArrayListExtra(itineraryConstants.ITINERARY) as ArrayList<String>
    //----------------------------------------------------------------------------------------------

    //----Show the data-----------------------------------------------------------------------------
        var itineraryList = findViewById<ListView>(R.id.list_itinerary)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itinerary)
        itineraryList.adapter = adapter
    //----------------------------------------------------------------------------------------------

        itineraryList.onItemClickListener = AdapterView.OnItemClickListener()
        {
                _, _, i, _ ->
            val intent = Intent(this, PackageDetailActivity::class.java)
            intent.putExtra(PackageDetailActivity.paquetConstants.PAQUET, itinerary[i])
            startActivity(intent)
        }
    }
}