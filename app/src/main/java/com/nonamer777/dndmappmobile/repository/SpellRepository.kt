package com.nonamer777.dndmappmobile.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.nonamer777.dndmappmobile.model.Spell
import com.nonamer777.dndmappmobile.repository.exception.SpellRetrievalException
import com.nonamer777.dndmappmobile.ui.MainActivity
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import java.lang.Exception

class SpellRepository {

    private val firestore = FirebaseFirestore.getInstance()

    private val spellCollection = firestore.collection("spells")

    private val _spells = MutableLiveData<List<Spell>>()

    val spells: LiveData<List<Spell>> get() = _spells

    suspend fun getSpells() = try { withTimeout(5_000) {
        val data = spellCollection.get().await()
        val spells = arrayListOf<Spell>()

        for (spellObj in data) {
            spells.add(spellObj.toObject(Spell::class.java))
        }
        _spells.value = spells

    }} catch (exception: Exception) {
        Log.e(MainActivity.FIRESTORE_TAG, exception.message.toString())
        throw SpellRetrievalException("Retrieval-firebase-task has failed")
    }
}
