package com.example.arrayadapter

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var peopleList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var personListView: ListView
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personListView = findViewById(R.id.personListView)
        addButton = findViewById(R.id.addButton)

        peopleList = ArrayList()
        adapter = ArrayAdapter(this, R.layout.list_item, R.id.firstNameTextView, peopleList)
        personListView.adapter = adapter

        addButton.setOnClickListener {
            addRandomPerson()
        }
    }

    private fun addRandomPerson() {
        val firstNames = resources.getStringArray(R.array.first_names)
        val lastNames = resources.getStringArray(R.array.last_names)

        val random = Random
        val firstName = firstNames[random.nextInt(firstNames.size)]
        val lastName = lastNames[random.nextInt(lastNames.size)]

        val person = "$firstName $lastName"
        peopleList.add(person)

        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Добавлен: $person", Toast.LENGTH_SHORT).show()
    }
}
