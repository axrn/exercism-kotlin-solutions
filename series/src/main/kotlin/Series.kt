package Series

fun slices(n: Int, s: String): List<List<Int>>{
    val res = mutableListOf<List<Int>>()
    var i = 0
    while(i <= s.length-n) {
        res.add(s.slice(i..i+n-1).map { it.toString().toInt() })
        i++
    }
    return res
}