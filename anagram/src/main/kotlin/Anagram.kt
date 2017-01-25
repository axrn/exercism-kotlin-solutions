class Anagram(val s: String) {
    val sArr = s.toLowerCase().toCharArray().sorted()
    fun match(words: List<String>) = words
                .filter { it.toLowerCase().toCharArray().sorted() == sArr }
                .filterNot { it.toLowerCase() == s.toLowerCase() }
}