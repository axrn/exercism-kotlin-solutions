package Binary

fun toDecimal(binary: String) =
    if (binary.all { it in "10" })
        binary.reversed()
                .mapIndexed { i, c -> c.toString().toInt() * (1 shl i) }
                .sum()
    else 0