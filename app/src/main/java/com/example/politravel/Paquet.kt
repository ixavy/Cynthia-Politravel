package com.example.politravel

import java.io.Serializable

class Paquet (val id: Int,
              val name: String,
              val imgHigh: Int,
              val imgLow: Int,
              val transport: String,
              val startingPointName: String,
              val endingPointName: String,
              val days: Int,
              val startingPointCoordinates: Int,
              val itineraryStopsName: MutableList<String>): Serializable