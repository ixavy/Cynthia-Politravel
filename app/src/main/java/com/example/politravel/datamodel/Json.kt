package com.example.politravel.datamodel

import android.content.Context
import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileWriter

class Json {
    object jsonNames{
        const val SPANISH = "paquets_cast.json"
        const val CATALAN = "paquets_cat.json"
        const val  ENGLISH = "paquets_eng.json"
    }
    companion object
    {
        fun getPaquets(context: Context, jsonName: String): MutableList<Paquet> {
            val jsonFilePath = context.filesDir.toString() + "/json/" + jsonName
            val jsonFile = FileReader(jsonFilePath)
            val listPlayerType = object : TypeToken<MutableList<Paquet>>() {}.type
            return Gson().fromJson(jsonFile, listPlayerType)
        }

        fun savePaquets(context: Context, paquets: MutableList<Paquet>, jsonName: String){
            val jsonFilePath = context.filesDir.toString() + "/json/" + jsonName
            val jsonFile = FileWriter(jsonFilePath)
            var gson = Gson()
            var jsonElement = gson.toJson(paquets)
            jsonFile.write(jsonElement)
            jsonFile.close()
        }
    }
}