class Luhn(val num: Long) {
    private fun calcAddend(n: Long): List<Int> {
        val strNum = n.toString()
        var startIndex = when {
            strNum.length % 2 == 0 -> 0
            else -> 1
        }

        val res = strNum
                .split("")
                .filterNot { it.isBlank() }
                .map { it.toString().toInt() }
                .toMutableList()

        for(i in startIndex..strNum.length-1 step 2) {
            res[i] *= 2
            if (res[i] > 9) res[i] -= 9
        }

        return res
    }

    val checkDigit = (num % 10).toInt()
    val addends = calcAddend(num)

    val checksum: Int = addends.sum()
    val isValid: Boolean = checksum % 10 == 0

    val create: Long by lazy {
        val numWithZero: Long = num * 10
        val luhn = Luhn(numWithZero)
        if (luhn.isValid)
            numWithZero
        else
            numWithZero + (10 - luhn.checksum % 10)
    }
}