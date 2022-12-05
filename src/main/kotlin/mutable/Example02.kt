package mutable

import kotlin.concurrent.thread

fun main() {
    val list = mutableListOf(1, 2, 3)
    val _list = list.map { it * 2 }
    thread {
        Thread.sleep(500)
        list[0] = 5
    }
    printFirstElementTwoTime(list)
}

fun printFirstElementTwoTime(list: List<Int>) {
    println("First element: ${list.first()}")
    Thread.sleep(1000)
    println("First element: ${list.first()}")
}