package org.ovechka.shamankingspirits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {

   lateinit var listOfSpirits: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfSpirits = findViewById(R.id.listOfSpirits)
        listOfSpirits.layoutManager = LinearLayoutManager(this)

        val gson = Gson()
        val file = assets.open("spirits.json").bufferedReader().use { it.readText() }
        val container = gson.fromJson(file, SpiritsContainer::class.java)

        val adapter = SpiritsAdapter(container!!.entries, this)
        listOfSpirits.adapter = adapter
        listOfSpirits.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
    }

}