package delegation

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("${prop.name} Is Change $old to $new")
        println("$old -> $new")
    }
}

fun main() {
    val user = User()

    user.name = "roach"
    println(user.name) // name Is Change <no name> to roach
    user.name = "roach roach"
    println(user.name) // name Is Change roach to roach roach
}

/**
 * Result
 * name Is Change <no name> to roach
 * <no name> -> roach
 * roach
 * name Is Change roach to roach roach
 * roach -> roach roach
 * roach roach
 */
