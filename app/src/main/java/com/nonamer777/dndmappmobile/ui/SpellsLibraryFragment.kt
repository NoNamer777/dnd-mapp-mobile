package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.FragmentSpellsLibraryBinding
import com.nonamer777.dndmappmobile.ui.viewModels.SpellViewModel

/**
 * A [Fragment] subclass that serves as a library of Spells.
 */
class SpellsLibraryFragment: Fragment() {

    private lateinit var binding: FragmentSpellsLibraryBinding

    private val spellViewModel: SpellViewModel by activityViewModels()

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

        observeRequests()

        spellViewModel.getSpells(requireActivity())
    }

    private fun observeRequests() {
        spellViewModel.spells.observe(viewLifecycleOwner, {
            Log.d("SpellsLibraryFragment", it.toString())
        })
    }
}
