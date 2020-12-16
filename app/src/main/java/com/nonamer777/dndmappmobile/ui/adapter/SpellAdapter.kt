package com.nonamer777.dndmappmobile.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.ItemSpellBinding
import com.nonamer777.dndmappmobile.model.Spell

class SpellAdapter(

    private val spells: List<Spell>,

    private val onClick: (Spell) -> Unit
): RecyclerView.Adapter<SpellAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = ItemSpellBinding.bind(itemView)

        init {
            itemView.setOnClickListener { onClick(spells[adapterPosition]) }
        }

        fun bind(spell: Spell) {
            binding.labelName.text = spell.name
            binding.labelLevelAndSchool.text = "${spell.levelString()}, ${spell.schoolOfMagic}"

            var components = ""
            var durationAndConcentration = ""

            for (component in spell.components!!) {
                components += component[0].toUpperCase()

                if (spell.components.last() != component) components += ", "
            }
            binding.labelComponents.text = components

            if (spell.concentration!!) {
                durationAndConcentration += " Concentration, "
            }
            durationAndConcentration += spell.duration

            binding.labelDurtionAndConcentration.text = durationAndConcentration
            binding.labelCatingTime.text = spell.castingTime
            binding.labelRange.text = spell.range
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_spell,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(spells[position])

    override fun getItemCount(): Int = spells.size
}
