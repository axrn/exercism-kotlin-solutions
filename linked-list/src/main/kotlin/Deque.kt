data class Node<T> (
        var next: Node<T>? = null,
        var prev: Node<T>? = null,
        val value: T
)

class Deque<T>() {
    private var firstNode: Node<T>? = null

    fun push(el: T) {
        if (firstNode == null) {
            firstNode = Node<T>(value = el)
        } else {
            val last = findLastNode()
            last?.next = Node<T>(prev = last, value = el)
        }
    }

    fun pop(): T? {
        val last = findLastNode()

        if (last == firstNode) {
            val value = firstNode?.value
            firstNode = null
            return value
        }

        val parentNode = last?.prev
        last?.prev = null
        parentNode?.next = null

        return last?.value
    }

    fun shift(): T? {
        val first = firstNode
        firstNode = firstNode?.next
        return first?.value
    }

    fun unshift(el: T) {
        val newNode = Node<T>(next = firstNode, value = el)
        if (firstNode == null) {
            firstNode = newNode
        } else {
            firstNode?.prev = newNode
            firstNode = newNode
        }
    }

    private fun findLastNode(): Node<T>? {
        var lastNode: Node<T>? = firstNode

        while(lastNode?.next != null) {
            lastNode = lastNode?.next
        }

        return lastNode
    }
}