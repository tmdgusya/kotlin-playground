package delegation

class AnimalInfo(
    val dbData: Animal
) {
    val name by dbData::name
    val int by dbData::age
    val origin by dbData::origin
    override fun toString(): String {
        return "The Animal is (name='$name', int=$int, origin='$origin')"
    }
}

fun main() {
    val animal = Animal(
        name = "rabbit",
        age = 5,
        origin = "USA"
    )
    val personInfo = AnimalInfo(dbData = animal)

    println(personInfo)
}
