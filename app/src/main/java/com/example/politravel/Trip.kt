package com.example.politravel

class Trip (val startingPointName: String,
           val endingPointName: String,
           val days: Int,
           val startingPointCoordinates: Int,
           val itineraryStopsName: MutableList<String>)