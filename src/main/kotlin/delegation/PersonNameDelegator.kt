package delegation

import kotlin.reflect.KProperty

class PersonNameDelegator {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun main() {
    val p = Person()

    println(p.name)
    p.name = "roach"
    println(p.name)
}
