package com.example.politravel

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaquetDetailActivity: AppCompatActivity() {
    object paquetConstants{
        const val PAQUET = "PAQUET"
        const val PLANE = "Plane"
        const val  AVE = "Ave"
        const val CAR = "Car"
        const val BUS = "Bus"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paquets_detail)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent
        val paquet: Paquet = intent.getSerializableExtra(paquetConstants.PAQUET) as Paquet
    //----------------------------------------------------------------------------------------------

    //----Put the data in the layout----------------------------------------------------------------

        //-----Image--------------------------------------------------------------------------------
        val img = findViewById<ImageView>(R.id.img_paquet_high)
        val paquetPath = filesDir.toString() + "/img/" + paquet.img_high
        val bitmap = BitmapFactory.decodeFile(paquetPath)
        img.setImageBitmap(bitmap)
        //------------------------------------------------------------------------------------------

        val name = findViewById<TextView>(R.id.name_paquet_detail)
        name.text = paquet.name

        val days = findViewById<TextView>(R.id.days_paquet_detail)
        days.text = paquet.days.toString() + " " + resources.getString(R.string.dias)

        val origin = findViewById<TextView>(R.id.origin_paquet_detail)
        origin.text = paquet.starting_point

        val destiny = findViewById<TextView>(R.id.destiny_paquet_detail)
        destiny.text = paquet.end_point

        val startingPoint = findViewById<TextView>(R.id.starting_point_paquet_detail)
        startingPoint.text = paquet.starting_point

        //----Transport image-----------------------------------------------------------------------
        val transportImg = findViewById<ImageView>(R.id.transport_img_detail)
        when (paquet.transport) {
            paquetConstants.PLANE ->
                transportImg.setImageResource(R.drawable.transp_plane)
            paquetConstants.CAR ->
                transportImg.setImageResource(R.drawable.transp_car)
            paquetConstants.AVE ->
                transportImg.setImageResource(R.drawable.transp_train)
            paquetConstants.BUS ->
                transportImg.setImageResource(R.drawable.transp_bus)
            else -> {
                Toast.makeText(this, "An error ocurred", Toast.LENGTH_LONG).show()
            }
        }
        //------------------------------------------------------------------------------------------

        //TODO Fragment googleMaps
            //val imgOrigin = findViewById<ImageView>(R.id.img_origin)
            //imgOrigin.setImageResource(paquet.startPointImg)

        val itineraryBtn = findViewById<Button>(R.id.itinerary_button_detail)
        itineraryBtn.setOnClickListener(){
            val intent = Intent(this, ItineraryListActivity::class.java)
            var itineraryList: ArrayList<String> = paquet.itinerary
            intent.putExtra(ItineraryListActivity.itineraryConstants.ITINERARY, itineraryList)
            startActivity(intent)
        }

        val edit = findViewById<ImageView>(R.id.edit_img_detail)
        edit.setOnClickListener{
            val intent = Intent(this, PaquetEditActivity::class.java)
            intent.putExtra(paquetConstants.PAQUET, paquet)
            startActivity(intent)
        }
    }
}