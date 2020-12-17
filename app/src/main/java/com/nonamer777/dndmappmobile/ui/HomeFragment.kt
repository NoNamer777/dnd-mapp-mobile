package com.nonamer777.dndmappmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.databinding.FragmentHomeBinding

/**
 * A [Fragment] subclass that serves as the home screen of the application.
 */
class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        MainActivity.actionBar?.title = getString(R.string.app_name)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigator = findNavController()

        binding.btnSpellsDictionary.setOnClickListener {
            navigator.navigate(R.id.action_homeFragment_to_spellsLibraryFragment)
        }

        binding.btnCharactersOverview.setOnClickListener {
            navigator.navigate(R.id.action_homeFragment_to_charactersOverviewFragment)
        }

        binding.btnCreateCharacter.setOnClickListener {
            navigator.navigate(R.id.action_homeFragment_to_characterCreatorFragment)
        }
    }
}
