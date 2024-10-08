package com.example.b1906314_bt_tuan_9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.b1906314_bt_tuan_9.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val items = ArrayList<MyAndroid>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEvents()
        binding.rvListItems.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MyAndroidRVAdapter(this, items)
        binding.rvListItems.adapter = adapter
    }

    private fun addEvents() {

        binding.myCustomSpinner.adapter = MyAndroidAdater(this, items)

        items.add(MyAndroid(1, R.drawable.cupcake, "Cupcake", "Cupcake"))
        items.add(MyAndroid(2, R.drawable.donut, "Donut", "Donut"))
        items.add(MyAndroid(3, R.drawable.eclairs, "Eclairs", "Eclairs"))
        items.add(MyAndroid(4, R.drawable.froyo, "Froyo", "Froyo"))
        items.add(MyAndroid(5, R.drawable.gingerbread, "Gingerbread", "Gingerbread"))
        items.add(MyAndroid(6, R.drawable.honeycomb, "Honeycomb", "Honeycomb"))
        items.add(MyAndroid(7, R.drawable.icecream, "Icecream", "Icecream"))
        items.add(MyAndroid(8, R.drawable.jellybean, "Jellybean", "Jellybean"))


        val options = arrayOf("Option 1", "Option 2", "Option 3", "Option 4")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.mySpinner.adapter = adapter

        binding.mySpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val selected = options[position]
                Toast.makeText(this@MainActivity, "you selected $selected",  Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.btnSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                savePrefs(binding.edtKey.text.toString(), binding.edtValue.text.toString())
            }
        }
        binding.btnRead.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                binding.tvReadValue.text = readPrefs(binding.edtReadKey.text.toString())
            }
        }
    }

    suspend fun savePrefs(key: String, value: String) {
        val _key = stringPreferencesKey(key)
        dataStore.edit { settings ->
            settings[_key] = value
        }
    }

    suspend fun readPrefs(key: String): String {
        val _key = stringPreferencesKey(key)
        val _value: Flow<String> = dataStore.data.map { settings ->

            settings[_key] ?: "No value"
            }
        return _value.first().toString()
        }

    }


