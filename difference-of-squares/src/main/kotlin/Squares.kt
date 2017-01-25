class Squares(val n: Int){
    fun squareOfSum() = (1..n).sum().square()
    fun sumOfSquares() = (1..n).sumBy { it.square() }
    fun difference() = squareOfSum() - sumOfSquares()
    fun Int.square() = this * this
}