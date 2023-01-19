package com.example.politravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity: AppCompatActivity()
{
    private var languages: Spinner?=null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-----Cambiar idioma-----------------------------------------------------------------------
        var lang: String
        val main = Intent(this, MainActivity::class.java)

        val languagesList = arrayOf("", "Español", "Català", "English")
        var adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, languagesList)

        languages = findViewById(R.id.spinner_language)
        languages?.adapter=adapter

        languages?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                when(position)
                {
                    1 ->
                    {
                        lang = "es"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    2 ->
                    {
                        lang = "ca"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    3 ->
                    {
                        lang = "en"
                        setLocale(lang, "rUS")
                        startActivity(main)
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //------------------------------------------------------------------------------------------

        val info = findViewById<ImageView>(R.id.info)
        info.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        val continuar = findViewById<LinearLayout>(R.id.click)
        continuar.setOnClickListener{
            val intent = Intent(this, PaquetListActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setLocale(lang: String, loc: String)
    {
        val locale = Locale(lang, loc)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}
