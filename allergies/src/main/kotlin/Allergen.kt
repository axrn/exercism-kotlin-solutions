enum class Allergen(val score: Int) {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128)
}

class Allergies(val score: Int){

    fun isAllergicTo(allergic: Enum<Allergen>) = Allergen.valueOf(allergic.name).score <= score

    fun getList(): List<Allergen> {
        val mapAllergens = Allergen.values().map { it.score to it.name }.toMap()
        val scores = mapAllergens.keys.sortedBy { -it }
        val result = mutableListOf<Allergen>()

        var tmpScore = score

        for(scr in scores) {
            if (tmpScore / scr >= 1) {
                result.add(Allergen.valueOf(mapAllergens.get(scr) ?: "CAT"))
                tmpScore -= scr * (tmpScore / scr)
                if (tmpScore <= 0) break
            }
        }

        return result.reversed()
    }
}