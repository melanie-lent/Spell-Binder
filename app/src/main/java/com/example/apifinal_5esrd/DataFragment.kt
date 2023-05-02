package com.example.apifinal_5esrd

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val TAG = "DataFragment"
private const val ARG_ASSET = "asset"

class DataFragment : Fragment() {
    private lateinit var beatBox: BeatBox

    private lateinit var dataRecyclerView: RecyclerView
    private lateinit var backButton: Button
    private lateinit var nextButton: Button
    private var adapter: SpellAdapter = SpellAdapter(emptyList())
    private val responseLiveData: MutableLiveData<List<SpellItem>> = MutableLiveData()

    interface Callbacks {
        fun onSpellSelected(spell: SpellItem)
    }

    private var idx: Int = 0

    private var callbacks: Callbacks? = null

    private fun updateUI(spells: List<SpellItem>) {
        adapter = SpellAdapter(spells)
        dataRecyclerView.adapter = adapter

        // hide next if youve gone to page 7
        if (idx >= 6) {
            nextButton.visibility = View.INVISIBLE
        } else {
            nextButton.visibility = View.VISIBLE
        }

        // hide back if youve gone to page 0
        if (idx <= 0) {
            backButton.visibility = View.INVISIBLE
        } else {
            backButton.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)

        val assets = activity?.assets

        beatBox = assets?.let { BeatBox(it) }!!
        val sounds = beatBox.sounds


        DataFetcher().fetchContents(idx, responseLiveData)
        responseLiveData.observe(
            viewLifecycleOwner,
            Observer { responseString ->

                Log.d(TAG, "Response received: $responseString")
                updateUI(responseString)
            }
        )

        dataRecyclerView = view.findViewById(R.id.data_recycler_view)
        backButton = view.findViewById(R.id.back_button)
        nextButton = view.findViewById(R.id.next_button)
        dataRecyclerView.layoutManager = LinearLayoutManager(context)
        dataRecyclerView.adapter = adapter

        backButton.visibility = View.INVISIBLE

        Log.d(TAG, "spell page ${idx.toString()}")

        backButton.setOnClickListener {
            if (idx > 0) {
                beatBox.play(sounds[0])
                idx--;
//                Log.d(TAG, "spell page ${idx.toString()}")
                nextButton.visibility = View.VISIBLE
                DataFetcher().fetchContents(idx, responseLiveData)
            } else {
                backButton.visibility = View.INVISIBLE
            }
        }

        nextButton.setOnClickListener {
            // increment page
            if (idx < 6) {
                idx++;
                beatBox.play(sounds[0])
//                Log.d(TAG, "spell page ${idx.toString()}")
                backButton.visibility = View.VISIBLE
                DataFetcher().fetchContents(idx, responseLiveData)
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    private inner class SpellHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var spell: SpellItem

        private val nameTextView: TextView = itemView.findViewById(R.id.spell_name)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(spell: SpellItem) {
            this.spell = spell

            nameTextView.text = this.spell.name
        }
        override fun onClick(v: View?) {
            Log.d(TAG, "clicked spell")
            callbacks?.onSpellSelected(spell)
        }
    }

    private inner class SpellAdapter(var spells: List<SpellItem>): RecyclerView.Adapter<SpellHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellHolder {
            val view = layoutInflater.inflate(R.layout.list_item_spell, parent, false)
            return SpellHolder(view)
        }

        override fun onBindViewHolder(holder: SpellHolder, position: Int) {
            val spell = spells[position]
            holder.bind(spell)
        }

        override fun getItemCount() = spells.size
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }

    companion object {
        fun newInstance(): DataFragment {
            val fragment = DataFragment()
            return fragment
        } /*= DataFragment().apply {
            arguments = Bundle().apply {
                putString("DATA FRAGMENT API URL: ", apiUrl)
            }
        }*/
    }
}