package mutable

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.util.Collections

fun main() {
    val list = MutableList<Int>(3) { it + 1 }.toImmutableList()
    val firstEle = getFirstElement(list)
    val reversedEle = reverseList(list)

    println("Reversed list: $reversedEle")
    println("First element: $firstEle")
}

fun reverseList(list: ImmutableList<Int>): List<Int> {
    val copiedList = list.deepCopy()
    return copiedList.reversed()
}

fun getFirstElement(list: List<Int>): Int {
    return list.first()
}

fun <E> List<E>.deepCopy(): List<E> {
    val list = ArrayList<E>(this.size)
    for (element in this) {
        list.add(element)
    }
    return list
}