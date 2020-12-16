package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.FragmentBaseCharacterOptionsBinding

/**
 * A [Fragment] subclass that serves as the starting point of the Character Creator process.
 */
class BaseCharacterOptionsFragment: Fragment() {

    private lateinit var binding: FragmentBaseCharacterOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseCharacterOptionsBinding.inflate(layoutInflater)

        MainActivity.actionBar?.title = getString(R.string.title_character_creator)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        super.onViewCreated(view, savedInstanceState)
}
