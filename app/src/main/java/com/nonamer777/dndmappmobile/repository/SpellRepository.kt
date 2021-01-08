package com.nonamer777.dndmappmobile.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nonamer777.dndmappmobile.api.DnD5eApi
import com.nonamer777.dndmappmobile.model.CommonModel
import com.nonamer777.dndmappmobile.model.Spell
import com.nonamer777.dndmappmobile.repository.exception.SpellRetrievalException
import com.nonamer777.dndmappmobile.service.DnD5eApiService
import com.nonamer777.dndmappmobile.ui.MainActivity
import com.nonamer777.dndmappmobile.ui.viewModel.SpellViewModel
import kotlinx.coroutines.withTimeout
import java.lang.Exception

class SpellRepository {

    private val dnD5eApi: DnD5eApiService = DnD5eApi.createAPI()

    private val _spells = MutableLiveData<List<Spell>>()

    val spells: LiveData<List<Spell>> get() = _spells

    suspend fun getSpells(level: Int?) = try {
        val result = dnD5eApi.getSpells(level)

        _spells.value = arrayListOf()

        for (index in 0..20) {
            getSpell(result.results[index])
        }
        SpellViewModel.isFetchingSpells.value = false

    } catch (exception: Exception) {
        Log.e(MainActivity.API_TAG, exception.message!!)

        throw SpellRetrievalException("Unable to fetch Spells", exception)
    }

    private suspend fun getSpell(spellReference: CommonModel) = try {
        val result = dnD5eApi.getSpell(spellReference.index!!)

        (_spells.value as ArrayList<Spell>).add(result)

    } catch (exception: Exception) {
        Log.e(MainActivity.API_TAG, exception.message!!)

        throw SpellRetrievalException("Unable to fetch Spell: '${spellReference.index}'", exception)
    }
}
