package delegation


class BB {
    fun test(s: String): String {
        println(s)
        return s.let { it + "123123" }
    }
}