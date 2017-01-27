package  Hexadecimal

private val hexChars = ('0'..'9') + ('a'..'f')

fun toDecimal(s: String) = s.toLowerCase().fold(0, { accum, char ->
    when (char) {
        in hexChars -> hexChars.indexOf(char) + (accum * 16)
        else -> return 0
    }
})