package com.example.politravel.datamodel

class Trip (val startingPointName: String,
           val endingPointName: String,
           val days: Int,
           val startingPointCoordinates: Int,
           val itineraryStopsName: MutableList<String>)