package org.ovechka.shamankingspirits

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpiritsContainer(
    val entries: List<Spirit>
)