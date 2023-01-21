package com.example.politravel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.politravel.R
import java.util.*

/**
 * Principal activity (initial)
 */
class MainActivity: AppCompatActivity()
{
    object languageConstants{
        const val SPANISH = "es"
        const val CATALAN = "ca"
        const val  ENGLISH = "en"
        const val LANGUAGE = "Language"
    }
    private var languages: Spinner?=null
    var lang: String = "ca"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-----Change language----------------------------------------------------------------------
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
            val intent = Intent(this, PackageListActivity::class.java)
            intent.putExtra(languageConstants.LANGUAGE, this.lang)
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
