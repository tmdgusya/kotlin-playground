package delegation

class Person {
    var name: String by PersonNameDelegator()
    val ageInKorea: Int = 20
    val ageInUSA: Int by lazy {
        ageInKorea - 1
    }
}
