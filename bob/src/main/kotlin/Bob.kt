package Bob

fun hey(s: String) =
        when {
            s.isBlank() -> "Fine. Be that way!"
            s.isUpperWithoutNumbers() -> "Whoa, chill out!"
            s.last().equals('?') -> "Sure."
            else -> "Whatever."
        }

private fun String.isUpperWithoutNumbers() = run {
    val onlyLetters = this.filter { it.isLetter() }
    onlyLetters.toUpperCase().equals(onlyLetters) && onlyLetters.isNotBlank()
}