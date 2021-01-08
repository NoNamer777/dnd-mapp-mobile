package com.nonamer777.dndmappmobile.model

import com.google.gson.annotations.SerializedName

data class Spell(

    @SerializedName("desc")
    val description: List<String>,

    @SerializedName("higher_level")
    val higherLevel: List<String>,

    @SerializedName("range")
    val range: String,

    @SerializedName("components")
    val components: List<String>,

    @SerializedName("material")
    val materialComponents: String,

    @SerializedName("ritual")
    val ritual: Boolean,

    @SerializedName("duration")
    val duration: String,

    @SerializedName("concentration")
    val concentration: Boolean,

    @SerializedName("casting_time")
    val castingTime: String,

    @SerializedName("level")
    val level: Int,

    @SerializedName("attack_type")
    val attackType: String,

    @SerializedName("school")
    val magicSchool: MagicSchool

): CommonModel() {

    fun levelString(): String = when (level) {
        0 -> "Cantrip"
        1 -> "1st-level"
        2 -> "2nd-level"
        3 -> "3rd-level"
        else -> "${level}th-level"
    }
}
