package RomanNumeral

fun value(decimal: Int): String {
    val romDigits = mapOf(
            1000 to "M",
            500  to "D",
            100  to "C",
            50   to "L",
            10   to "X",
            5    to "V",
            1    to "I"
    )
    val digits = decimal.toString().reversed().map { it.toString().toInt() }

    val romResult = digits.mapIndexed { i, digit ->
        val powTen = 10.pow(i)

        when {
            digit == 0 -> ""
            digit in 1..3 -> romDigits[powTen]?.repeat(digit)
            digit == 4 ->  "${romDigits[powTen]}${romDigits[powTen * 5]}"
            digit == 5 -> romDigits[powTen * 5]
            digit in 6..8 -> "${romDigits[powTen*5]}${romDigits[powTen]?.repeat(digit - 5)}"
            digit == 9 -> "${romDigits[powTen]}${romDigits[powTen * 10]}"
            else -> throw IllegalStateException()
        }
    }

    return romResult.reversed().joinToString("")
}

fun Int.pow(power: Int) = Math.pow(this.toDouble(), power.toDouble()).toInt()