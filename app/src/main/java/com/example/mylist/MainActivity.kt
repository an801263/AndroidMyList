package com.example.mylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var items = Array<AndVersion>(15, { AndVersion("nom", "description",1) })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seedItems()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AndVersionAdapter(items)
    }

    fun seedItems() {
        val nameArray = resources.getStringArray(R.array.name)
        val imgArray = intArrayOf(R.drawable.cake, R.drawable.donut, R.drawable.eclair, R.drawable.cake, R.drawable.donut, R.drawable.eclair,R.drawable.cake, R.drawable.donut, R.drawable.eclair,R.drawable.cake, R.drawable.donut, R.drawable.eclair,R.drawable.cake, R.drawable.donut, R.drawable.eclair)
        val desc = resources.getStringArray(R.array.des)
        for (i in 0..(nameArray.size - 1))
            items[i] = AndVersion(nameArray[i],desc[i], imgArray[i])
    }

    private fun updateObjectList(adapter: AndVersionAdapter) {
        adapter.notifyDataSetChanged()
    }
}