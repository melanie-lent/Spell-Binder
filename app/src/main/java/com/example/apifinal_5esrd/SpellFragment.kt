package com.example.apifinal_5esrd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
import java.util.*

private const val TAG = "SpellFragment"

private const val ARG_NAME = "name"
private const val ARG_DESC = "desc"
private const val ARG_HIGHER_LEVEL = "higher_level"
private const val ARG_RANGE = "range"
private const val ARG_COMPONENTS = "components"
private const val ARG_MATERIAL = "material"
private const val ARG_RITUAL = "ritual"
private const val ARG_DURATION = "duration"
private const val ARG_CASTING_TIME = "casting_time"
private const val ARG_LEVEL = "level"
private const val ARG_SCHOOL = "school"
private const val ARG_DND_CLASS = "dnd_class"
private const val ARG_ARCHETYPE = "archetype"
private const val ARG_CIRCLES = "circles"

class SpellFragment: Fragment() {

    private lateinit var spell: SpellItem

    private lateinit var nameField: TextView
    private lateinit var descField: TextView
    private lateinit var higherLevelField: TextView
    private lateinit var rangeField: TextView
    private lateinit var componentsField: TextView
    private lateinit var materialField: TextView
    private lateinit var ritualField: TextView
    private lateinit var durationField: TextView
    private lateinit var castingTimeField: TextView
    private lateinit var levelField: TextView
    private lateinit var schoolField: TextView
    private lateinit var dndClassField: TextView
    private lateinit var archetypeField: TextView
    private lateinit var circlesField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        spell = SpellItem()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spell, container, false)
        val name = arguments?.getString(ARG_NAME)
        val desc = arguments?.getString(ARG_DESC)
        val higher_level = arguments?.getString(ARG_HIGHER_LEVEL)
        val range = arguments?.getString(ARG_RANGE)
        val components = arguments?.getString(ARG_COMPONENTS)
        val material = arguments?.getString(ARG_MATERIAL)
        val ritual = arguments?.getString(ARG_RITUAL)
        val duration = arguments?.getString(ARG_DURATION)
        val casting_time = arguments?.getString(ARG_CASTING_TIME)
        val level = arguments?.getString(ARG_LEVEL)
        val school = arguments?.getString(ARG_SCHOOL)
        val dnd_class = arguments?.getString(ARG_DND_CLASS)
        val archetype = arguments?.getString(ARG_ARCHETYPE)
        val circles = arguments?.getString(ARG_CIRCLES)

        nameField = view.findViewById(R.id.spell_name)
        descField = view.findViewById(R.id.spell_desc)
//        higherLevelField = view.findViewById(R.id.spell_higher_level)
        rangeField = view.findViewById(R.id.spell_range)
        componentsField = view.findViewById(R.id.spell_components)
        materialField = view.findViewById(R.id.spell_material)
        ritualField = view.findViewById(R.id.spell_ritual)
        durationField = view.findViewById(R.id.spell_duration)
        castingTimeField = view.findViewById(R.id.spell_casting_time)
        levelField = view.findViewById(R.id.spell_level)
        schoolField = view.findViewById(R.id.spell_school)
        dndClassField = view.findViewById(R.id.spell_dnd_class)
//        archetypeField = view.findViewById(R.id.spell_archetype)
//        circlesField = view.findViewById(R.id.spell_circles)

        nameField.text = name
        if (desc != null) {
            descField.text = desc.replace(".**", ":").replace("**", "")
        }
//        higherLevelField.text = "Higher Level: $higher_level"
        rangeField.text = "Range: $range"
        componentsField.text = components
        if (material != "") {
            materialField.text = "Materials: $material"
        } else {
            materialField.text = "Materials: None"
        }
        if (ritual != "no") {
            ritualField.text = "Ritual"
        } else {
            ritualField.text = ""
        }
        durationField.text = "Duration: $duration"
        castingTimeField.text = "Casting Time: $casting_time"
        if (level != "Cantrip") {
            levelField.text = "$level spell"
        } else {
            levelField.text = level
        }
        schoolField.text = school
        dndClassField.text = dnd_class
//        archetypeField.text = archetype
//        circlesField.text = circles

        // return view
        return view
    }

    companion object {
        fun newInstance(spellitem: SpellItem): SpellFragment {

            val fragment = SpellFragment()

            val bundle = Bundle().apply {
                putString(ARG_NAME, spellitem.name)
                putString(ARG_DESC, spellitem.desc)
                putString(ARG_HIGHER_LEVEL, spellitem.higher_level)
                putString(ARG_RANGE, spellitem.range)
                putString(ARG_COMPONENTS, spellitem.components)
                putString(ARG_MATERIAL, spellitem.material)
                putString(ARG_RITUAL, spellitem.ritual)
                putString(ARG_DURATION, spellitem.duration)
                putString(ARG_CASTING_TIME, spellitem.casting_time)
                putString(ARG_LEVEL, spellitem.level)
                putString(ARG_SCHOOL, spellitem.school)
                putString(ARG_DND_CLASS, spellitem.dnd_class)
                putString(ARG_ARCHETYPE, spellitem.archetype)
                putString(ARG_CIRCLES, spellitem.circles)
            }

            fragment.arguments = bundle

            return fragment
        }
    }
}