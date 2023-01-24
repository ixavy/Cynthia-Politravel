package com.example.politravel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.politravel.R
import com.example.politravel.datamodel.Json
import com.example.politravel.datamodel.Paquet
import kotlinx.coroutines.NonDisposableHandle.equals
import java.util.*

/**
 * Principal activity (initial)
 */
class MainActivity: AppCompatActivity()
{

override fun onCreate(savedInstanceState: Bundle?)
{
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)



    // Datos iniciales -------------------------------------------------

    val paquets: ArrayList<Paquet> = arrayListOf(
        Paquet(1,
            "Paquete 1",
            this.getImgIdFromImgName("id_1_principal"),
            this.getImgIdFromImgName("id_1_llista"),
            "Plane",
            "Punto Salida 1",
            232.343,
            12.343,
            20,
            "end point 1",
            23,
            arrayListOf(
                "Cuenca",
                "Toledo",
                "Madrid",
                "Zaragoza",
                "Barcelona"
            )
        ),
        Paquet(2,
            "Paquete 2",
            this.getImgIdFromImgName("id_2_principal"),
            this.getImgIdFromImgName("id_2_llista"),
            "Bus",
            "Punto Salida 2",
            232.343,
            12.343,
            20,
            "End point 2",
            23,
            arrayListOf(
                "Sabadell",
                "Terrassa",
                "Mollet",
                "Esplugues",
                "Badalona"
            )
        ),
        Paquet(3,
            "Paquete 3",
            this.getImgIdFromImgName("id_3_principal"),
            this.getImgIdFromImgName("id_3_llista"),
            "Ave",
            "Punto Salida 3",
            232.343,
            12.343,
            20,
            "end point 3",
            23,
            arrayListOf(
                "Cadiz",
                "Sevilla",
                "Cordoba",
                "Granada",
                "Malaga"
            )
        )
    )

    Json.savePaquets(this, paquets, "paquets.json")

    val info = findViewById<ImageView>(R.id.info_icon)
    info.setOnClickListener {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }

    val continuar = findViewById<LinearLayout>(R.id.initial_layout)
    continuar.setOnClickListener{
        val intent = Intent(this, PackageListActivity::class.java)
        startActivity(intent)
    }
}

override fun onResume() {
    super.onResume()
    Toast.makeText(this, getString(R.string.continuar), Toast.LENGTH_LONG).show()
}

    fun getImgIdFromImgName(imgName: String): Int {
        return this.resources.getIdentifier(imgName, "drawable", this.packageName)
    }
}
