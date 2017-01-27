class Robot(){
    var name = generateName()

    companion object {
        private val USEDNAMES = mutableSetOf<String>()
    }

    fun reset(){
        name = generateName()
    }

    private fun generateName(): String{
        fun gen() = ('A'..'Z').getRandom(2) + ('0'..'9').getRandom(3)
        var newName = gen()
        while (newName in USEDNAMES)
            newName = gen()
        USEDNAMES.add(newName)
        return newName
    }

    fun CharRange.getRandom(n: Int) = (1..n).map {
            "${ elementAt((Math.random() * count()).toInt())}"
        }.joinToString("")
}