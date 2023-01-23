package com.example.politravel.datamodel

import android.content.Context
import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileWriter

class Json {
    object jsonName{
        const val JSON = "paquets.json"
    }
    companion object
    {
        fun getPaquets(context: Context, jsonName: String): ArrayList<Paquet> {
            val jsonFilePath = context.filesDir.toString() + "/json/" + jsonName
            val jsonFile = FileReader(jsonFilePath)
            val listPlayerType = object : TypeToken<MutableList<Paquet>>() {}.type
            return Gson().fromJson(jsonFile, listPlayerType)
        }

        fun savePaquets(context: Context, paquets: ArrayList<Paquet>, jsonName: String){
            val jsonFilePath = context.filesDir.toString() + "/json/" + jsonName
            val jsonFile = FileWriter(jsonFilePath)
            var gson = Gson()
            var jsonElement = gson.toJson(paquets)
            jsonFile.write(jsonElement)
            jsonFile.close()
        }
    }
}