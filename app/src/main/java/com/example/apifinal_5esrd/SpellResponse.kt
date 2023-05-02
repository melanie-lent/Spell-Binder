package com.example.apifinal_5esrd

import com.google.gson.annotations.SerializedName

class SpellResponse {
    @SerializedName("results")
    lateinit var subjectItems: List<SpellItem>
}