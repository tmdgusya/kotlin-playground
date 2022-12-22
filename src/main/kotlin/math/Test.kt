package math

//private tailrec fun triangular(n: Int): Int = if (n == 0) 0 else n + triangular(n - 1)

//private fun triangular2(n: Int): Int = (1 .. n).fold(0) { acc, i -> acc + i }

private fun quad(n: Int): Int = n * n

fun main() {
//    mutableListOf<Int>().also {
//        for (i in 0 .. 10000) {
//            it.add(triangular(i))
//        }
//    }.run {
//        for (i in 0 .. 10000) {
//            if (this.contains(quad(i))) println(quad(i))
//        }
//    }

    println(triangular(100_000_000))
}

private tailrec fun triangular(n: Int, acc: Int = 0): Int = if (n == 0) acc else triangular(n - 1, acc + n)