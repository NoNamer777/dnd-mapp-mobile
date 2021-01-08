package com.nonamer777.dndmappmobile.service

import com.nonamer777.dndmappmobile.model.Spell
import com.nonamer777.dndmappmobile.model.SpellReferenceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DnD5eApiService {

    @GET("spells")
    suspend fun getSpells(
        @Query("level") level: Int?,
        @Query("school") magicSchool: String?
    ): SpellReferenceResponse

    @GET("spells/{index}")
    suspend fun getSpell(@Path("index") spellIndex: String): Spell
}
