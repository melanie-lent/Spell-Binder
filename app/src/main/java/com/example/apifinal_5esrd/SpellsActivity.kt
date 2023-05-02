package com.example.apifinal_5esrd

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SpellsActivity : AppCompatActivity(), DataFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_spells)
        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.spellsFragmentContainer, DataFragment.newInstance())
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onSpellSelected(spell: SpellItem) {
        val fragment = SpellFragment.newInstance(spell)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.spellsFragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

/*    private inner class SoundHolder(private val binding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(binding.root) {

        }

    private inner class SoundAdapter() :
        RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
                layoutInflater,
                R.layout.
            )
        }
    }*/

    companion object {
        fun newIntent(packageContext: Context): Intent {
            val intent = Intent(packageContext, SpellsActivity::class.java)
            return intent
        }
    }
}