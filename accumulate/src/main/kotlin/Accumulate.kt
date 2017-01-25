package Accumulate

fun <T> accumulate(list: List<T>, f: (T) -> Any): List<Any> {
    val acc = mutableListOf<Any>()
    for(i in list)
        acc += f(i)
    return acc
}