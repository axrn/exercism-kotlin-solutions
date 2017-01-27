package Pangrams

fun isPangram(text: String): Boolean {
    val lowText = text.toLowerCase()
    return ('a'..'z').all { it in lowText }
}