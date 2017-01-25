package BinarySearch

fun search(list: List<Int>, x: Int): Int {
    for(i in 1..list.size-1) {
        if ( list[i] < list[i-1] ) throw IllegalArgumentException()
    }

    var left = 0
    var right = list.size

    while(right - left > 1) {
        val middle = (right + left) / 2

        when {
            x == list[middle] -> return middle
            x < list[middle] -> right = middle
            else -> left = middle
        }
    }

    return if (list[left] == x) left else -1
}