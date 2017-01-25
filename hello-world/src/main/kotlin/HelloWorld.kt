object HelloWorld {
    fun hello(name: String? = "World") =
            if (name.isNullOrBlank()) "Hello, World!" else "Hello, $name!"
}