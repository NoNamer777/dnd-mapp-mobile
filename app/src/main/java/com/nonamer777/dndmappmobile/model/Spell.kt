package com.nonamer777.dndmappmobile.model

data class Spell(

    val name: String? = null,
    val level: Int? = null,
    val schoolOfMagic: String? = null,
    val ritual: Boolean? = null,
    val castingTime: String? = null,
    val range: String? = null,
    val components: List<String>? = null,
    val materialComponents: List<String>? = null,
    val concentration: Boolean? = null,
    val duration: String? = null,
    val description: Map<String, String>? = null,
    val leveledCasting: LeveledCasting? = null,
    val upCasting: String? = null
) {

    fun canBeCastAtHigherLevel(): Boolean = upCasting != null

    fun scalesWithPlayerLevel(): Boolean = leveledCasting != null

    fun levelString(): String = when (level) {
        0 -> "Cantrip"
        1 -> "1st-level"
        2 -> "2nd-level"
        3 -> "3rd-level"
        else -> "${level}th-level"
    }
}
