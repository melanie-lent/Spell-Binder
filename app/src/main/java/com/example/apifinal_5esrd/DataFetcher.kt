package com.example.apifinal_5esrd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apifinal_5esrd.api.open5eApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "DataFetcher"

class DataFetcher {
    private val dataApi: open5eApi
    private var apiUrl: String = ""

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.open5e.com/spells/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dataApi = retrofit.create(open5eApi::class.java)
    }

    fun fetchContents(idx: Int, livedata: MutableLiveData<List<SpellItem>>) {
        var dataRequest: Call<SpellResponse>

        /*when (apiUrl) {
            "spells" -> dataRequest = dataApi.fetchSpells()
            "monsters" -> dataRequest = dataApi.fetchSpells()
            else -> dataRequest = dataApi.fetchSubjects()
        }*/

        if (idx == 1) {
            dataRequest = dataApi.fetchSpells2()
        } else if (idx == 2) {
            dataRequest = dataApi.fetchSpells3()
        } else if (idx == 3) {
            dataRequest = dataApi.fetchSpells4()
        } else if (idx == 4) {
            dataRequest = dataApi.fetchSpells5()
        } else if (idx == 5) {
            dataRequest = dataApi.fetchSpells6()
        } else if (idx == 6) {
            dataRequest = dataApi.fetchSpells7()
        } else {
            dataRequest = dataApi.fetchSpells1()
        }

        dataRequest.enqueue(object : Callback<SpellResponse> {
            override fun onFailure(call: Call<SpellResponse>, t: Throwable) {
//                Log.e(TAG, "Failed to fetch data", t)
            }

            override fun onResponse(call: Call<SpellResponse>, response: Response<SpellResponse>) {
                Log.d(TAG, "response received:  ${response.body()}")
                val subjectResponse: SpellResponse? = response.body()
                var subjectItems: List<SpellItem> = subjectResponse?.subjectItems
                    ?: mutableListOf()
                /*subjectItems = subjectItems.filterNot {
                    it.url.isBlank()
                }*/
                livedata.value = subjectItems
            }
        })
    }
}