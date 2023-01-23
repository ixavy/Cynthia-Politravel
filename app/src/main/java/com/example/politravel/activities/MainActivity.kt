package com.example.politravel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.politravel.R
import com.example.politravel.datamodel.Paquet
import kotlinx.coroutines.NonDisposableHandle.equals
import java.util.*

/**
 * Principal activity (initial)
 */
class MainActivity: AppCompatActivity()
{
    object languageConstants{
        const val SPANISH = "español"
        const val CATALAN = "català"
        const val  ENGLISH = "en"
        const val LANGUAGE = "Language"
    }
    val locale: String = Locale.getDefault().getDisplayName()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    private fun setLocale(lang: String, loc: String)
    {
        val locale = Locale(lang, loc)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}
