package com.abudnitski.imagesearcher.presentation.detail

import javax.inject.Inject

class ConvertorHelper @Inject constructor() {
    fun convert(data: Int): String {
        return when {
            data >= 10000000 -> "${data / 1000}M"
            data >= 1000000 -> "${data / 1000}M"
            data >= 100000 -> "${data / 1000}K"
            data >= 10000 -> "${data / 1000}K"
            else -> data.toString()
        }
    }

    fun convert(input: String): String {
        return input.split(", ")
            .map { it.replace(" ", "_") }
            .joinToString(" ") { "#$it" }
    }
}