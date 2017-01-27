package Isogram

fun isIsogram (str: String): Boolean {
    val prepStr = str.toLowerCase().filter { it.isLetter() }
    return prepStr.toSet().size == prepStr.length
}