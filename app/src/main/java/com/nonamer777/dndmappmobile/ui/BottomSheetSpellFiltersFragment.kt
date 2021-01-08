package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nonamer777.dndmappmobile.databinding.FragmentBottomSheetSpellFiltersBinding
import com.nonamer777.dndmappmobile.ui.viewModel.SpellViewModel

/**
 * A [BottomSheetDialogFragment] subclass that contains the logic for the spell filter bottom sheet.
 */
class BottomSheetSpellFiltersFragment: BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetSpellFiltersBinding

    private lateinit var dialog: BottomSheetDialog

    private val spellViewModel: SpellViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetSpellFiltersBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnApplyFilters.setOnClickListener {
            val level: String = binding.inputSpellLevel.text.toString()

            if (!isValidSpellLevel(level)) {
                Toast.makeText(requireContext(), "Invalid Spell level", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            spellViewModel.getSpells(requireActivity(), level.toIntOrNull())

            this.dismiss()
        }
    }

    private fun isValidSpellLevel(level: String): Boolean = when {
        level.isBlank() || level.isDigitsOnly() -> true
        else -> false
    }
}
