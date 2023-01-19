package com.example.politravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PaquetDetailActivity: AppCompatActivity() {
    object paquetConstants{
        const val PAQUET = "PAQUET"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paquets_detail)
    }
}