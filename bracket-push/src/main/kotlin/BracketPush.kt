package BracketPush

fun isValid(str: String): Boolean {
    val stack = mutableListOf<Char>()

    val braces = mapOf (
            '}' to '{',
            ']' to '[',
            ')' to '('
    )

    for(char in str) {
        when {
            char in "}])" -> {
                if (stack.size == 0) return false
                val lastOpenBrace = stack.removeAt(stack.lastIndex)
                if ( lastOpenBrace != braces[char] ) return false
            }
            char in "{[(" -> stack.add(char)
        }
    }

    return stack.size == 0
}