object Atbash {

    val cipherEncode = ('a'..'z').zip('z' downTo 'a').toMap()
    val cipherDecode = ('z' downTo 'a').zip('a'..'z').toMap()

    fun encode(phrase: String) = phrase.toLowerCase()
            .filter { it.isLetterOrDigit() }
            .map { cipherEncode.getOrElse(it, {it}) }
            .joinToString("")
            .replace(Regex("((.){5})"), "$1 ")
            .trim()

    fun decode(phrase: String) = phrase.toLowerCase()
            .filter { it.isLetterOrDigit() }
            .map{ cipherDecode.getOrElse(it, {it}) }
            .joinToString("")

}