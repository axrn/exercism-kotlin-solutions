class DNA(val dnaString: String){

    val NUCLEOTIDES = listOf('A', 'C', 'G', 'T')

    init{
        if (dnaString.any { it !in NUCLEOTIDES })
            throw IllegalArgumentException()
    }

    val nucleotideCounts = NUCLEOTIDES.map { it to count(it) }.toMap()

    fun count(nucleotide: Char) =
            if (nucleotide in NUCLEOTIDES)
                dnaString.count { it == nucleotide }
            else
                throw IllegalArgumentException()
}