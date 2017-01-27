class Year(year: Int) {
    val isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
}