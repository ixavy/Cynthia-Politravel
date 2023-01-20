package com.example.politravel.activities

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.datamodel.Paquet
import com.example.politravel.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class PaquetDetailActivity: AppCompatActivity(), OnMapReadyCallback {
    object paquetConstants{
        const val PAQUET = "PAQUET"
        const val PLANE = "Plane"
        const val  AVE = "Ave"
        const val CAR = "Car"
        const val BUS = "Bus"
    }

    private lateinit var map: GoogleMap
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

        val destiny = findViewById<TextView>(R.id.end_point_paquet_detail)
        destiny.text = paquet.end_point

        val startingPoint = findViewById<TextView>(R.id.starting_point_paquet_detail)
        startingPoint.text = paquet.starting_point

        //----Transport image-----------------------------------------------------------------------
        val transportImg = findViewById<ImageView>(R.id.transport_img_detail)
        paquet.setTransportImg(this, paquet.transport, transportImg)
        //------------------------------------------------------------------------------------------

        //TODO Fragment googleMaps
            //val imgOrigin = findViewById<ImageView>(R.id.img_origin)
            //imgOrigin.setImageResource(paquet.startPointImg)
        createFragmentStartPoint()

        val itineraryBtn = findViewById<Button>(R.id.itinerary_button_detail)
        itineraryBtn.setOnClickListener(){
            val intent = Intent(this, ItineraryListActivity::class.java)
            var itineraryList: ArrayList<String> = paquet.itinerary
            intent.putExtra(ItineraryListActivity.itineraryConstants.ITINERARY, itineraryList)
            startActivity(intent)
        }

        createFragmentEndPoint()

        /*val edit = findViewById<ImageView>(R.id.edit_img_detail)
        edit.setOnClickListener{
            val intent = Intent(this, PaquetEditActivity::class.java)
            intent.putExtra(paquetConstants.PAQUET, paquet)
            startActivity(intent)
        }*/
    }

    private fun createFragmentStartPoint(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_start_point) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun createFragmentEndPoint(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_end_point) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}