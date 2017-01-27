package PigLatin

fun translate(input: String): String {
    val inputArr = input.split(" ").filter { it.isNotBlank() }
    val res = mutableListOf<String>()
    for (s in inputArr){
        if (s.indexOf("yt") == 0 || s.indexOf("xr") == 0) {
            res.add(s + "ay")
        } else {
            res.add(s.substring(s.indexOfVowel()) + s.substring(0..s.indexOfVowel() - 1) + "ay")
        }
    }
    return res.joinToString(" ")
}

fun String.indexOfVowel(): Int {
    val quIndex = this.indexOf("qu")
    val anyVowelIndex = this.indexOfAny("aeiou".toCharArray())
    if (quIndex != -1 && quIndex < anyVowelIndex) return quIndex + 2
    return anyVowelIndex
}