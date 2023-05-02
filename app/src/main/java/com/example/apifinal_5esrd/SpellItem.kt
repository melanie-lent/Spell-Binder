package com.example.apifinal_5esrd

import com.google.gson.annotations.SerializedName

data class SpellItem(
    var name: String = "",
    var desc: String = "",
    var higher_level: String = "",
    var range: String = "",
    var components: String = "",
    var material: String = "",
    var ritual: String = "",
    var duration: String = "",
    var casting_time: String = "",
    var level: String = "",
    var school: String = "",
    var dnd_class: String = "",
    var archetype: String = "",
    var circles: String = "",
)