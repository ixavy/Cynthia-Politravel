package com.example.politravel.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R

class ItineraryDetailEditActivity: AppCompatActivity() {
    object itineraryConstants{
        const val ITINERARY = "ITINERARY"
    }
    lateinit var itinerary:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_detail_edit)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent.extras
        itinerary = intent?.getString(itineraryConstants.ITINERARY) as String
    //----------------------------------------------------------------------------------------------

        val deleteBtn = findViewById<Button>(R.id.button_delete_itinerary)
        deleteBtn.setOnClickListener{
            //TODO program delete a package
        }

        val saveBtn = findViewById<Button>(R.id.button_save_itinerary)
        saveBtn.setOnClickListener{
            //TODO program save a package
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, getString(R.string.edit), Toast.LENGTH_LONG).show()
    }
}