class School(){
    private val db = mutableMapOf<Int, List<String>>()

    fun db() = mapOf<Int, List<String>>() + db

    fun add(name: String, grade: Int) =
        db.put(grade, db.getOrElse(grade) {listOf<String>()} + name)

    fun grade(grade: Int) = db().getOrElse(grade) {listOf<String>()}

    fun sort() =
                db()
                    .map { it.key to it.value.sorted() }
                    .toMap()
                    .toSortedMap()
}