package Scrabble

fun scoreWord(s: String): Int {

    val readableDict = mapOf( 1 to listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
                              2 to listOf('D', 'G'),
                              3 to listOf('B', 'C', 'M', 'P'),
                              4 to listOf('F', 'H', 'V', 'W', 'Y'),
                              5 to listOf('K'),
                              8 to listOf('J', 'X'),
                             10 to listOf('Q', 'Z') )

    val processingDict = readableDict.flatMap { entry -> entry.value.map { it to entry.key } }.toMap()

    return s.scrabble(processingDict)
}

fun String.scrabble(d: Map<Char, Int>) = sumBy { d.getOrElse(it.toUpperCase(), {0}) }