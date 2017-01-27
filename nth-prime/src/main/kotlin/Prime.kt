package Prime

fun nth(n: Int): Int {
    when {
        n < 1 -> throw IllegalArgumentException()
        n == 1 -> return 2
    }
    var primeCounter = 1
    outter@ for (i in 3..Int.MAX_VALUE) {
        for (j in 2..Math.sqrt(i.toDouble()).toInt()) {
            if (i % j == 0) {
                continue@outter
            }
        }
        primeCounter++
        if (primeCounter == n) return i
    }
    return 0
}