package com.example.politravel.datamodel

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.example.politravel.R
import com.example.politravel.activities.PaquetDetailActivity
import java.io.Serializable

class Paquet (val id: Int,
              val name: String,
              val img_low: String,
              val img_high: String,
              val transport: String,
              val starting_point: String,
              val coordinates: Coordinate,
              val zoom: Int,
              val end_point: String,
              val days: Int,
              val itinerary: ArrayList<String>): Serializable
{
   fun setTransportImg(context: Context, transport: String, transportImg: ImageView)
   {
       when (transport) {
           PaquetDetailActivity.paquetConstants.PLANE ->
               transportImg.setImageResource(R.drawable.transp_plane)
           PaquetDetailActivity.paquetConstants.CAR ->
               transportImg.setImageResource(R.drawable.transp_car)
           PaquetDetailActivity.paquetConstants.AVE ->
               transportImg.setImageResource(R.drawable.transp_train)
           PaquetDetailActivity.paquetConstants.BUS ->
               transportImg.setImageResource(R.drawable.transp_bus)
           else -> {
               Toast.makeText(context, "An error ocurred", Toast.LENGTH_LONG).show()
           }
       }
   }
}
