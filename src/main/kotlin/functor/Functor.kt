package functor

import kotlin.Nothing

interface Functor<out A> {
    fun <B> map(f: (A) -> B): Functor<B>
}

sealed class Maybe<out A>: Functor<A> {
    abstract override fun toString(): String
    abstract override fun <B> map(f: (A) -> B): Maybe<B>
}

data class Just<out A>(val value: A): Maybe<A>() {
    override fun <B> map(f: (A) -> B): Maybe<B> = Just(f(value))
}

object Nothing: Maybe<Nothing>() {
    override fun toString(): String = "Nothing"
    override fun <B> map(f: (Nothing) -> B): Maybe<B> = Nothing
}

fun main() {
    println(Just(10).map { it + 10 }) // "Just(20)"
    println(functor.Nothing.map { a: Int -> a + 10 }) // print Nothing
}