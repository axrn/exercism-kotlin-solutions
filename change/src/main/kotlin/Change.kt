class Change(coins: Set<Int>) {
    private val sortedCoins = coins.toList().sorted()

    fun issue(n: Int): List<Int> {
        if (n < 0) throw IllegalArgumentException()

        val possibleChanges = mutableListOf<List<Int>>()
        var possibleCoins = sortedCoins
        while(possibleCoins.size > 1) {
            possibleChanges.add( getChangeVariant(n, possibleCoins) )
            possibleCoins = possibleCoins.slice(0..possibleCoins.size-2)
        }

        return possibleChanges.minBy { it.size } ?: listOf<Int>()
    }

    private fun getChangeVariant(n: Int, possibleCoins: List<Int>): List<Int> {
        var restCoins = n;
        val changeCoins = mutableListOf<Int>()
        while(restCoins > 0) {
            val maxCoin = findMaxCoin(restCoins, possibleCoins)
            if (maxCoin == -1) throw IllegalArgumentException()
            changeCoins.add(maxCoin)
            restCoins -= maxCoin
        }

        return changeCoins.reversed()
    }

    private fun findMaxCoin(x: Int, possibleCoins: List<Int>): Int {
        var coinsMaxToMin = possibleCoins.reversed()
        for(coin in coinsMaxToMin) {
            if (x >= coin) return coin
        }

        return -1
    }
}