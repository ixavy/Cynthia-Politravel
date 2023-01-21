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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PackageDetailActivity: AppCompatActivity(), OnMapReadyCallback {
    object paquetConstants{
        const val PAQUET = "PAQUET"
        const val PLANE = "Plane"
        const val  AVE = "Ave"
        const val CAR = "Car"
        const val BUS = "Bus"
    }
    lateinit var paquet:Paquet
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_detail)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent
        paquet= intent.getSerializableExtra(paquetConstants.PAQUET) as Paquet
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
        createFragmentStartPoint()

        val itineraryBtn = findViewById<Button>(R.id.itinerary_button_detail)
        itineraryBtn.setOnClickListener(){
            val intent = Intent(this, ItineraryListActivity::class.java)
            var itineraryList: ArrayList<String> = paquet.itinerary
            intent.putExtra(ItineraryListActivity.itineraryConstants.ITINERARY, itineraryList)
            startActivity(intent)
        }

        val add = findViewById<FloatingActionButton>(R.id.add)
        add.setOnClickListener{
            val intent = Intent(this, PackageEditActivity::class.java)
            intent.putExtra(paquetConstants.PAQUET, paquet)
            startActivity(intent)
        }
    }

    private fun createFragmentStartPoint(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_start_point) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarkerStratPoint()
    }

    private fun createMarkerStratPoint(){
        val coordinates = LatLng(paquet.lat, paquet.lng)
        val markerStartPoint = MarkerOptions().position(coordinates).title(this.paquet.starting_point)
        map.addMarker(markerStartPoint)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
        4000,
        null)
    }
}