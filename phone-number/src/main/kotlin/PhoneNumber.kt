class PhoneNumber(private var n: String){
    val number: String
    init {
        n = n.filter { it.isDigit() }
        number = when {
            n.length == 10 -> n
            n.length == 11 && n.first() == '1' -> n.substring(1)
            else -> "0000000000"
        }
    }
    val areaCode = number.slice(0..2)

    override fun toString() =
            "(${areaCode}) ${number.slice(3..5)}-${number.slice(6..9)}"
}