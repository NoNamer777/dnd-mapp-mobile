package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.FragmentCharactersOverviewBinding

/**
 * A [Fragment] subclass that serves as the Character overview screen.
 */
class CharactersOverviewFragment: Fragment() {

    private lateinit var binding: FragmentCharactersOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersOverviewBinding.inflate(layoutInflater)

        MainActivity.actionBar?.title = getString(R.string.title_characters_overview)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        super.onViewCreated(view, savedInstanceState)
}
