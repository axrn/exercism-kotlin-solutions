package WordCount

fun phrase(s: String) = s
            .toLowerCase()
            .replace(Regex("[^\\w']"), " ")
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }
            .groupBy { it }
            .map { it.key to it.value.size }
            .toMap()