package org.ovechka.shamankingspirits

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Spirit(
    val name: String,
    val href: String,
    val photo: String
)