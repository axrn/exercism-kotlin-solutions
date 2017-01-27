package PascalsTriangle

fun computeTriangle(n: Int): List<List<Int>> {
    if (n < 0) {
        throw IllegalArgumentException()
    }

    val triangleList = mutableListOf<List<Int>>()

    out@ for (i in 0..n - 1) {
        when (i) {
            0 -> {
                triangleList.add(listOf(1));
                continue@out
            }
            1 -> {
                triangleList.add(listOf(1, 1));
                continue@out
            }
        }

        val prevLine = triangleList[i - 1]
        val newLine = mutableListOf<Int>()
        newLine.add(1)
        for (j in 1..prevLine.size - 1) {
            newLine.add(prevLine[j - 1] + prevLine[j])
        }
        newLine.add(1)
        triangleList.add(newLine)
    }

    return triangleList
}