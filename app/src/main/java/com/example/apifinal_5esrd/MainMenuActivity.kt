package com.example.apifinal_5esrd

import android.content.ClipData.newIntent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainMenuActivity : AppCompatActivity() {
    private lateinit var menuButtonSpells: Button
    private lateinit var menuButtonMonsters: Button
    private lateinit var menuButtonDocuments: Button
    private lateinit var menuButtonBackgrounds: Button
    private lateinit var menuButtonPlanes: Button
    private lateinit var menuButtonSections: Button
    private lateinit var menuButtonFeats: Button
    private lateinit var menuButtonConditions: Button
    private lateinit var menuButtonRaces: Button
    private lateinit var menuButtonClasses: Button
    private lateinit var menuButtonMagicItems: Button
    private lateinit var menuButtonWeapons: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        menuButtonSpells = findViewById(R.id.mm_button_spells)
        menuButtonMonsters = findViewById(R.id.mm_button_documents)
        menuButtonDocuments = findViewById(R.id.mm_button_backgrounds)
        menuButtonBackgrounds = findViewById(R.id.mm_button_backgrounds)
        menuButtonPlanes = findViewById(R.id.mm_button_planes)
        menuButtonSections = findViewById(R.id.mm_button_sections)
        menuButtonFeats = findViewById(R.id.mm_button_feats)
        menuButtonConditions = findViewById(R.id.mm_button_conditions)
        menuButtonRaces = findViewById(R.id.mm_button_races)
        menuButtonClasses = findViewById(R.id.mm_button_classes)
        menuButtonMagicItems = findViewById(R.id.mm_button_magic_items)
        menuButtonWeapons = findViewById(R.id.mm_button_weapons)

        menuButtonSpells.setOnClickListener {
            val intent = SpellsActivity.newIntent(this@MainMenuActivity)
            startActivity(intent)
        }
    }
}