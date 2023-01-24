package `interface`

import java.lang.IllegalArgumentException

fun applyAWithB(f: (a: Int, b:Int) -> Int): (Int) -> (Int) -> Int {
    fun applyA(a: Int): (Int) -> Int {
        fun applyB(b: Int): Int {
            return f(a, b)
        }

        return ::applyB
    }

    return ::applyA
}

class EmailSender: (String) -> Unit {
    override fun invoke(email: String) {
        println(email)
    }
}

fun <T : Any, R : Any> curriedLet(obj: T): ((T) -> R) -> R {
    fun executeBlockWithObj(block: (T) -> R): R {
        return block(obj)
    }

    return ::executeBlockWithObj
}

fun main() {
    val sender = EmailSender()
    sender.invoke(email = "roach@woowahan.com")
    val sum = { a: Int, b: Int -> a + b}
    val mult = {a: Int, b: Int -> a * b}
    applyAWithB(sum)(1)(2)
    applyAWithB(mult)(1)(2)
    val curriedFunc = applyAWithB(sum)
    val partialFunc = curriedFunc(1)
    val funcUsePartial = partialFunc(2)
    val funcUseOnlyCurrying = curriedFunc(1)(2)

    var a: Int? = 1
    val sumWithA = a?.let(curriedFunc) ?: throw IllegalArgumentException()
    val result = sumWithA(2)
    println(result)
    println(result)

    val applyBlockWithOne = curriedLet<Int, (Int) -> Int>(1)
    applyBlockWithOne(curriedFunc)
}