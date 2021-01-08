package com.nonamer777.dndmappmobile.model

import com.google.gson.annotations.SerializedName

data class SpellReferenceResponse (

    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    val results: List<CommonModel>
)
