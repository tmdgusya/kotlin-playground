package delegation

import collectionsaa.max

class Animal(
    var name: String,
    var age: Int,
    var origin: String
) {
    fun test() {
        max(listOf<Int>(), Int::compareTo)
    }
}

val Animal.a by lazy { 1 }