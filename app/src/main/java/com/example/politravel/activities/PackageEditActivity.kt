package com.example.politravel.activities

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R
import com.example.politravel.activities.PackageDetailActivity.paquetConstants.AVE
import com.example.politravel.activities.PackageDetailActivity.paquetConstants.BUS
import com.example.politravel.activities.PackageDetailActivity.paquetConstants.CAR
import com.example.politravel.activities.PackageDetailActivity.paquetConstants.PLANE
import com.example.politravel.datamodel.Paquet
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PackageEditActivity: AppCompatActivity(), OnMapReadyCallback {
    lateinit var paquet:Paquet
    private lateinit var map: GoogleMap
    object galleryConstants{
        const val PICK_IMAGE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_edit)

    //----Get the data------------------------------------------------------------------------------
        val intent = intent
        paquet = intent.getSerializableExtra(PackageDetailActivity.paquetConstants.PAQUET) as Paquet
    //----------------------------------------------------------------------------------------------

        //----Put the data in the layout----------------------------------------------------------------

        //-----Image--------------------------------------------------------------------------------
        val img = findViewById<ImageView>(R.id.img_paquet_high)
        val paquetPath = filesDir.toString() + "/img/" + paquet.img_high
        val bitmap = BitmapFactory.decodeFile(paquetPath)
        img.setImageBitmap(bitmap)
        //------------------------------------------------------------------------------------------

        val name = findViewById<TextView>(R.id.name_paquet_edit)
        name.text = paquet.name

        val days = findViewById<TextView>(R.id.days_paquet_edit)
        days.text = paquet.days.toString() + " " + resources.getString(R.string.dias)

        val endPoint = findViewById<TextView>(R.id.end_point_paquet_edit)
        endPoint.text = paquet.end_point

        val startingPoint = findViewById<TextView>(R.id.starting_point_paquet_edit)
        startingPoint.text = paquet.starting_point

        //----Transport image-----------------------------------------------------------------------
        val transportImg = findViewById<ImageView>(R.id.transport_img_edit)
        paquet.setTransportImg(this, paquet.transport, transportImg)
        //------------------------------------------------------------------------------------------

        val transports = findViewById<Spinner>(R.id.spinner_transport)

        val transportsList = arrayOf("", PLANE, AVE, CAR, BUS)
        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, transportsList)

        transports?.adapter=adapter
        transports?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> {
                        transportImg.setImageResource(R.drawable.transp_plane)
                    }
                    2 -> {
                        transportImg.setImageResource(R.drawable.transp_train)
                    }
                    3 -> {
                        transportImg.setImageResource(R.drawable.transp_car)
                    }
                    4 -> {
                        transportImg.setImageResource(R.drawable.transp_bus)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val iconNewImgPaquet = findViewById<ImageView>(R.id.new_img_paquet)
        iconNewImgPaquet.setOnClickListener{
            openGallery()
        }

        val itineraryBtn = findViewById<Button>(R.id.itinerary_button_edit)
        itineraryBtn.setOnClickListener(){
            val intent = Intent(this, ItineraryEditActivity::class.java)
            var itineraryList: ArrayList<String> = paquet.itinerary
            intent.putExtra(ItineraryListActivity.itineraryConstants.ITINERARY, itineraryList)
            startActivity(intent)
        }

        val deleteBtn = findViewById<Button>(R.id.button_delete)
        deleteBtn.setOnClickListener(){
            //TODO program delete a package
        }

        val saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn.setOnClickListener(){
            //TODO program save a package
        }
        createFragment()
    }
    fun openGallery(){
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, galleryConstants.PICK_IMAGE)
    }

    fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_start_point_edit) as SupportMapFragment
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
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null)
    }
}