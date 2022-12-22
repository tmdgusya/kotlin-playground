package delegation

interface Foo {
    val message: String
    fun print()
}

class FooImpl(val x: Int) : Foo {
    override val message: String = "Message of FooImpl"

    override fun print() {
        println(message)
    }
}

class Bar(foo: Foo) : Foo by foo {
    override val message: String = "Message of Bar"
}

fun main() {
    val foo = FooImpl(10)
    val bar = Bar(foo)
    bar.print()
    println(bar.message)
}