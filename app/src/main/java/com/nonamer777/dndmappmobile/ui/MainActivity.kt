package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    companion object {

        const val API_TAG = "DnD5eApi"

        var actionBar: ActionBar? = null
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        MainActivity.actionBar = supportActionBar
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        else -> super.onOptionsItemSelected(item)
    }
}
