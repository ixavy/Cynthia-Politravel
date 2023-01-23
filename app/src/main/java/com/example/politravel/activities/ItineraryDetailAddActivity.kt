package com.example.politravel.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R

/**
 * Adding one itinerary
 */
class ItineraryDetailAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_detail_add)

        val deleteBtn = findViewById<Button>(R.id.button_delete_new_itinerary)
        deleteBtn.setOnClickListener{
            //TODO program delete a package
        }

        val saveBtn = findViewById<Button>(R.id.button_save_new_itinerary)
        saveBtn.setOnClickListener{
            //TODO program save a package
        }
    }
}