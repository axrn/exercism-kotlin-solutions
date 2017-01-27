package Sieve

fun primesUpTo(n: Int): List<Int> {
    var s = listOf(2..n).flatten()
    var p = 2
    while(p < s.last()) {
        s = s.filter { if (it > p) it % p != 0 else true }
        p = s.first { it > p }
    }
    return s
}