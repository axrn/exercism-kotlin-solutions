package ETL

fun transform(m: Map<Int, List<String>>) = m
    .flatMap { entry -> entry.value.map { it.toLowerCase() to entry.key } }
    .toMap()