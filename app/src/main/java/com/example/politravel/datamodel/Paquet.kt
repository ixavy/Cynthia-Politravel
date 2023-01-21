package com.example.politravel.datamodel

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.example.politravel.R
import com.example.politravel.activities.PackageDetailActivity
import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

class Paquet(
    val id: Int,
    val name: String,
    val img_low: String,
    val img_high: String,
    val transport: String,
    val starting_point: String,
    val lat: Double,
    val lng: Double,
    val zoom: Int,
    val end_point: String,
    val days: Int,
    val itinerary: ArrayList<String>): Serializable
{

    fun setTransportImg(context: Context, transport: String, transportImg: ImageView)
   {
       when (transport) {
           PackageDetailActivity.paquetConstants.PLANE ->
               transportImg.setImageResource(R.drawable.transp_plane)
           PackageDetailActivity.paquetConstants.CAR ->
               transportImg.setImageResource(R.drawable.transp_car)
           PackageDetailActivity.paquetConstants.AVE ->
               transportImg.setImageResource(R.drawable.transp_train)
           PackageDetailActivity.paquetConstants.BUS ->
               transportImg.setImageResource(R.drawable.transp_bus)
           else -> {
               Toast.makeText(context, "An error ocurred", Toast.LENGTH_LONG).show()
           }
       }
   }
}
