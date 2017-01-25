object   BeerSong {

    val lyrics = verses(99, 0)

    fun verses(start: Int, end: Int): String {
        return (start downTo end).map { verse(it) }.joinToString("\n")
    }

    fun verse(n: Int): String {
        return when {
            n in 2..99 -> "${n} bottles of beer on the wall, ${n} bottles of beer.\nTake one down and pass it around, ${n - 1} ${if (n == 2) "bottle" else "bottles"} of beer on the wall.\n"
            n == 1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            n == 0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            n < 0  -> throw IllegalArgumentException("Beer song verse can't be negative")
            n > 99 -> throw IllegalArgumentException("Beer song only goes up to verse 99")
            else   -> ""
        }
    }
}