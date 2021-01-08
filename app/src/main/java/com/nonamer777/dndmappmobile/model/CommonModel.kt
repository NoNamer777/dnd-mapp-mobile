package com.nonamer777.dndmappmobile.model

import com.google.gson.annotations.SerializedName

open class CommonModel {

    @SerializedName("index")
    open val index: String? = null

    @SerializedName("name")
    open val name: String? = null

    @SerializedName("url")
    open val url: String? = null
}
