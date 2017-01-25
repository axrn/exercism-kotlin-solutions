package Hamming

fun compute(a: String, b: String): Int {
    if(a.length != b.length)
        throw IllegalArgumentException()
    return a.zip(b).count { it.first != it.second }
}