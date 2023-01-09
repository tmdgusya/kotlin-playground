package math

//private tailrec fun triangular(n: Int): Int = if (n == 0) 0 else n + triangular(n - 1)

//private fun triangular2(n: Int): Int = (1 .. n).fold(0) { acc, i -> acc + i }

fun main() {
    println("Hello World! ${A(3) + A(2) * A(2)}")
    A(5)
    A(3)
}

class A(private val v: Int) {

    operator fun plus(b: A): A {
        return A(v + b.v)
    }

    operator fun times(b: A): A {
        return A(v * b.v)
    }
}

