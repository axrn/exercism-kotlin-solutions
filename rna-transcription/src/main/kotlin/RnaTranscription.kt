fun transcribeToRna(s: String): String {
        fun inner(s2: Char) = when (s2) {
            'C' -> 'G'
            'G' -> 'C'
            'T' -> 'A'
            'A' -> 'U'
            else -> throw IllegalArgumentException() }
        return s.map{ inner(it) }.joinToString("")
    }
