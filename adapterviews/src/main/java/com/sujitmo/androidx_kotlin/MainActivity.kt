package com.sujitmo.androidx_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // View -> ViewGroup -> AdapterView -> ListView, GridView and Spinner

    // Adapter -> ListAdapter, SpinnerAdapter <- BaseAdapter -> ArrayAdapter, CustomAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customAdapterDemo()

    }

    private fun customAdapterDemo() {

        val rawDt = arrayListOf<MyItem>()
        rawDt.add(MyItem(R.drawable.ic_launcher_foreground, "Launcher"))
        rawDt.add(MyItem(R.drawable.ic_settings_black_24dp, "Settings"))
        rawDt.add(MyItem(R.drawable.ic_add_location_black_24dp, "Locations"))
        rawDt.add(MyItem(R.drawable.ic_bluetooth_black_24dp, "Bluetooth"))
        rawDt.add(MyItem(R.drawable.ic_battery_charging_50_black_24dp, "Battery"))

        val adapter = MyAdapter(this, rawDt)

        listView.adapter = adapter
    }

    private fun arraAdapterDemo() {
        val rawDt = arrayListOf<String>()
        rawDt.add("Android")
        rawDt.add("Apple")
        rawDt.add("Windows")
        rawDt.add("RIM")
        rawDt.add("WebOs")
        rawDt.add("PalmOs")

        val adapter = ArrayAdapter<String>(
            this@MainActivity,
            android.R.layout.simple_list_item_1,
            rawDt
        )

        listView.adapter = adapter
        btnAdd.setOnClickListener(this::added)

        listView.setOnItemClickListener { _, _, position, _ -> etMb.setText(rawDt[position]) }
        listView.setOnItemLongClickListener { _, _, position, _ ->
            adapter.remove(adapter.getItem(position))
            true
        }
    }

    private fun added(view: View) {
        (listView.adapter as ArrayAdapter<String>).add(etMb.text.toString())
        (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }
}