package iter

import java.util.stream.Stream

typealias A = String

fun main() {
    val strings = listOf<String>("Any", "Is", "A", "String", " ", " ")
    val result = averageNonBlankLength(strings.iterator().asSequence())
    println(result)
}

fun averageNonBlankLength(strings: Sequence<String>): Double = (strings
    .filter { it.isNotBlank() }
    .sumOf { it.length } / strings.count().toDouble())

fun averageNonBlankLengthByStream(strings: Stream<String>): Double = (strings
    .filter { it.isNotBlank() }
    .mapToInt { it.length }
    .sum() / strings.count().toDouble())

fun aa(): A = "a"