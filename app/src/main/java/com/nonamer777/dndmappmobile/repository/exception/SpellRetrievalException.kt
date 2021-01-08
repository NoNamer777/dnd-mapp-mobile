package com.nonamer777.dndmappmobile.repository.exception

import java.lang.Exception

data class SpellRetrievalException(override val message: String, override val cause: Throwable):
    Exception(message, cause)
