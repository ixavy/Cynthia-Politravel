package com.example.politravel.activities

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.politravel.R
import com.example.politravel.datamodel.Paquet
import org.w3c.dom.Text

/**
 * Add a package
 */
class PackageAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_add)

        //----Get the data------------------------------------------------------------------------------
        val intent = intent
        val paquets: ArrayList<Paquet> =
            intent.getSerializableExtra(PackageDetailActivity.paquetConstants.PAQUETS)
                    as ArrayList<Paquet>
        //----------------------------------------------------------------------------------------------

        val deleteBtn = findViewById<Button>(R.id.button_delete)
        deleteBtn.setOnClickListener{
            //TODO program delete a package
        }

        val saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn.setOnClickListener{

            val paquetName = findViewById<EditText>(R.id.name_paquet_add)
            val paquetDays = findViewById<EditText>(R.id.days_paquet_add)
            val paquetStartPoint = findViewById<EditText>(R.id.starting_point_paquet_add)
            val paquetEndPoint = findViewById<EditText>(R.id.end_point_paquet_add)

            val paquetImg = findViewById<ImageView>(R.id.img_paquet_high_add)
            val paquetTransport =  findViewById<ImageView>(R.id.transport_img_add)
            if(!paquetImg.equals(null)){

            }else{
                Toast.makeText(this, getString(R.string.img_null), Toast.LENGTH_LONG).show()
            }
        }

        val iconNewImgPaquet = findViewById<ImageView>(R.id.new_img_paquet)
        iconNewImgPaquet.setOnClickListener{
            openGallery()
            //TODO añadir la imagen
        }

        val transportImg = findViewById<ImageView>(R.id.transport_img_add)
        val transports = findViewById<Spinner>(R.id.spinner_transport_add)
        val transportsList = arrayOf("",
            PackageDetailActivity.paquetConstants.PLANE,
            PackageDetailActivity.paquetConstants.CAR,
            PackageDetailActivity.paquetConstants.AVE,
            PackageDetailActivity.paquetConstants.BUS
        )
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
                        transportImg.setImageResource(R.drawable.transp_car)
                    }
                    3 -> {
                        transportImg.setImageResource(R.drawable.transp_train)
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

        val startPoint = findViewById<EditText>(R.id.starting_point_paquet_add)
        //startPoint.

        val itinerary = findViewById<Button>(R.id.itinerary_button_add)
        itinerary.setOnClickListener(){
            val intent = Intent(this, ItineraryListEditAddActivity::class.java)
            startActivity(intent)
        }
    }

    fun openGallery(){
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PackageEditActivity.galleryConstants.PICK_IMAGE)
    }

}