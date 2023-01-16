package com.example.politravel_cynthia_garcia

class Paquet (val id: Int,
              val name: String,
              val imgHigh: Int,
              val imgLow: Int,
              val transport: String,
              val startingPointName: String,
              val endingPointName: String,
              val days: Int,
              val startingPointCoordinates: Int,
              val itineraryStopsName: MutableList<String>)