package com.example.politravel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.politravel.R
import java.util.*

class MainActivity: AppCompatActivity()
{
    object languageConstants{
        const val SPANISH = "Español"
        const val CATALAN = "Català"
        const val  ENGLISH = "English"
        const val LANGUAGE = "Language"
    }
    private var languages: Spinner?=null
    var language: String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-----Cambiar idioma-----------------------------------------------------------------------
        var lang: String
        val main = Intent(this, MainActivity::class.java)

        val languagesList = arrayOf("",
            languageConstants.SPANISH,
            languageConstants.CATALAN,
            languageConstants.ENGLISH
        )
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
                        language = languageConstants.SPANISH
                        lang = "es"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    2 ->
                    {
                        language = languageConstants.CATALAN
                        lang = "ca"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    3 ->
                    {
                        language = languageConstants.ENGLISH
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

        val info = findViewById<ImageView>(R.id.info_icon)
        info.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        val continuar = findViewById<LinearLayout>(R.id.initial_layout)
        continuar.setOnClickListener{
            val intent = Intent(this, PaquetListActivity::class.java)
            intent.putExtra(languageConstants.LANGUAGE, language)
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
