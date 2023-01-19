package com.example.politravel

import android.app.Activity
import android.content.Context
import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileWriter

class Json {
    companion object
    {
        fun getPaquets(context: Context): MutableList<Paquet> {
            val jsonFilePath = context.filesDir.toString() + "/json/paquets.json"
            val jsonFile = FileReader(jsonFilePath)
            val listPlayerType = object : TypeToken<MutableList<Paquet>>() {}.type
            return Gson().fromJson(jsonFile, listPlayerType)
        }

        fun savePaquets(context: Context, paquets: MutableList<Paquet>){
            val jsonFilePath = context.filesDir.toString() + "/json/paquets.json"
            val jsonFile = FileWriter(jsonFilePath)
            var gson = Gson()
            var jsonElement = gson.toJson(paquets)
            jsonFile.write(jsonElement)
            jsonFile.close()
        }
    }
}