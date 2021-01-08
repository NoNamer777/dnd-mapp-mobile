package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.FragmentSpellsLibraryBinding
import com.nonamer777.dndmappmobile.model.Spell
import com.nonamer777.dndmappmobile.ui.adapter.SpellAdapter
import com.nonamer777.dndmappmobile.ui.viewModel.SpellViewModel
import kotlin.properties.Delegates

/**
 * A [Fragment] subclass that serves as a library of Spells.
 */
class SpellsLibraryFragment: Fragment() {

    private lateinit var binding: FragmentSpellsLibraryBinding

    private val spellViewModel: SpellViewModel by activityViewModels()

    private val spells = arrayListOf<Spell>()

    private val spellAdapter = SpellAdapter(spells, ::onSpellClick)

    private var levelFilter: Int? = null

    private var magicSchoolFilter: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsLibraryBinding.inflate(layoutInflater)

        MainActivity.actionBar?.title = getString(R.string.title_spells_library)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spellList.adapter = spellAdapter
        binding.spellList.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        val bottomSheetSpellFiltersFragment = BottomSheetSpellFiltersFragment()

        binding.btnOpenFilterSpells.setOnClickListener {
            bottomSheetSpellFiltersFragment.show(
                requireActivity().supportFragmentManager,
                "SpellFilterFragment"
            )
        }

        observeRequests()

        spellViewModel.getSpells(requireActivity(), levelFilter, magicSchoolFilter)
    }

    private fun observeRequests() {
        SpellViewModel.isFetchingSpells.observe(viewLifecycleOwner, {
            when (it) {
                false -> {
                    binding.progressBar.visibility = View.INVISIBLE

                    spells.clear()
                    spells.addAll(spellViewModel.spells.value!!)
                    spellAdapter.notifyDataSetChanged()
                }
                else -> binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun onSpellClick(spell: Spell) {
        Toast.makeText(context, "showing detail of ${spell.name}", Toast.LENGTH_SHORT).show()
    }
}
