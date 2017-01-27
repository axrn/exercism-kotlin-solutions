class Cipher(customKey: String? = null) {

    init {
        require(customKey?.isNotBlank() ?: true)
        require(customKey?.all { it in 'a'..'z' } ?: true)
    }

    val key: String by lazy { customKey ?: genKey() }

    private val ALPHABET = ('a'..'z').toList().joinToString("")

    private fun genKey(): String {
        fun genRandomChar() = ('a'..'z').toList().elementAt((Math.random() * 26).toInt())
        return (1..100).map { genRandomChar() }.joinToString("")
    }

    fun encodeChar(inputChar: Char, keyChar: Char): Char {
        return ALPHABET.get((ALPHABET.indexOf(inputChar) + ALPHABET.indexOf(keyChar)) % 26)
    }

    fun decodeChar(inputChar: Char, keyChar: Char): Char {
        val index = ALPHABET.indexOf(inputChar) - ALPHABET.indexOf(keyChar)
        return ALPHABET.getOrElse(index) { ALPHABET.get(26 + index) }
    }

    fun encode(input: String): String {
        return input.mapIndexed { i, c -> encodeChar(c, key.get(i % key.length)) }.joinToString("")
    }

    fun decode(input: String): String {
        return input.mapIndexed { i, c -> decodeChar(c, key.get(i % key.length)) }.joinToString("")
    }
}