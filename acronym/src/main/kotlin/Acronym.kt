package Acronym

fun generate(phrase: String) = phrase
        .replace("([a-z])([A-Z])".toRegex(), "$1 $2")
        .split("[\\W]".toRegex())
        .filterNot { it.isBlank() }
        .map { it.first().toUpperCase() }
        .joinToString("")