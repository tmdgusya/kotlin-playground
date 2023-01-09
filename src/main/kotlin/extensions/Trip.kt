package extensions

import java.time.LocalDateTime

data class Trip(
    val name: String
)

fun Trip.reminderAt(time: LocalDateTime): String? = time.toString()

fun main() {
    val trip: Trip? = Trip("zzz")
}