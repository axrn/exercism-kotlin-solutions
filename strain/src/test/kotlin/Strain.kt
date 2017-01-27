package Strain

fun <T> keep(list: List<T>, f: (T) -> Boolean) = list.fold(listOf<T>()) {acc, p -> if(f(p)) acc + p else acc }

fun <T> discard(list: List<T>, f: (T) -> Boolean) = keep(list, { v -> !f(v) })