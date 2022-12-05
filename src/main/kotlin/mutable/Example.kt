package mutable

import java.util.Collections

fun main() {
    val list = mutableListOf(1, 2, 3)
    val firstEle = getFirstElement(list)
    val reversedEle = reverseList(list)

    println("Reversed list: $reversedEle")
    println("First element: $firstEle")
}

fun reverseList(list: List<Int>): List<Int> {
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