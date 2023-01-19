package com.example.politravel

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