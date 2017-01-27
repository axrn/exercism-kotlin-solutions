class Series(val s: String) {
    var series = mutableListOf<String>()
    init {
        if(!s.all { it.isDigit() }) throw IllegalArgumentException()
    }

    fun getLargestProduct(n: Int):Long {
        when {
            n < 0 -> throw IllegalArgumentException()
            n > s.length -> throw IllegalArgumentException()
        }

        series.clear()
        for(i in 0..s.length-n) {
            series.add(s.substring(i, i+n))
        }

        return series.map {
            it
                    .map { it.toString().toLong() }
                    .fold(1L) { acc, x -> x * acc }
        }.max()!!
    }
}