package com.nonamer777.dndmappmobile.ui.viewModel

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nonamer777.dndmappmobile.R
import com.nonamer777.dndmappmobile.model.Spell
import com.nonamer777.dndmappmobile.repository.SpellRepository
import com.nonamer777.dndmappmobile.repository.exception.SpellRetrievalException
import com.nonamer777.dndmappmobile.ui.MainActivity
import kotlinx.coroutines.launch

class SpellViewModel(application: Application): AndroidViewModel(application) {

    companion object {

        var isFetchingSpells = MutableLiveData(false)
    }

    private val spellRepo = SpellRepository()

    val spells: LiveData<List<Spell>> = spellRepo.spells

    private val _error = MutableLiveData<String>()

    val error: LiveData<String> get() = _error

    fun getSpells(activity: Activity, level: Int?, magicSchool: String?) = viewModelScope.launch {
        try {
            isFetchingSpells.value = true

            spellRepo.getSpells(level, magicSchool)

        } catch (exception: SpellRetrievalException) {
            val message = activity.getString(
                R.string.exception_message_retrieval_error,
                "Spells"
            )

            Log.e(MainActivity.API_TAG, exception.message ?: message)

            _error.value = message
        }
    }
}
