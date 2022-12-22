package math

import kotlin.math.sqrt

private fun triple(n: Int): Int = when {
    n <= 0 -> 0
    n == 1 -> 1
    else -> n + triple(n - 1)
}

private fun quad(n: Int): Int = n * n

fun main() {
    mutableListOf<Int>().also {
        for (i in 0 .. 10000) {
            it.add(triple(i))
        }
    }.run {
        for (i in 0 .. 10000) {
            if (this.contains(quad(i))) println(quad(i))
        }
    }

    println(sqrt(41616.0))
}