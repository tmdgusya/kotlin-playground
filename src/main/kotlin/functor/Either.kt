package functor

import java.util.NoSuchElementException

sealed class Either<out L, out R> : Functor<R> {
    abstract override fun <R2> map(f: (R) -> R2): Either<L, R2>
}

data class Left<out L>(val value: L): Either<L, kotlin.Nothing>() {
    override fun <R2> map(f: (kotlin.Nothing) -> R2): Either<L, R2> = this
}

data class Right<out R>(val value: R): Either<kotlin.Nothing, R>() {
    override fun <R2> map(f: (R) -> R2): Either<kotlin.Nothing, R2> = Right(f(value))
}


fun List<Int>.indexOfByF(n: Int): Either<NoSuchElementException, Int> {
    try {
        for (i in this.indices) {
            if (this[i] == n) return Right(i)
        }
    } catch(e: ArrayIndexOutOfBoundsException) {
        Left(NoSuchElementException())
    }
    return Left(NoSuchElementException())
}

fun <T> identity(x: T): T = x

fun main() {
    val list = listOf<Int>(1,2,3,4,5,6,7)
    println(list.indexOfByF(10).map { it / 2 }) // Left(value=java.util.NoSuchElementException)
    println(list.indexOfByF(2).map { it * 2 }) // Right(value=2)

    val result = list.indexOfByF(2).map { it * 2 }
    val resultWithIdentityF = result.map { identity(it) }
    println(result == resultWithIdentityF)
}