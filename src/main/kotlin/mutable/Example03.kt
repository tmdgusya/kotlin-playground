package mutable

import java.util.Objects
import java.util.concurrent.Executors

val threadPool = Executors.newFixedThreadPool(10)
val eventQueue = mutableListOf<Runnable>()

fun main() {
    // push event to queue
    eventQueue.add(Runnable {
        println("Hello Event!!")
    })

    // Pulling events from queue
    threadPool.execute {
        while (true) {
            val event = synchronized(eventQueue) {
                if (eventQueue.isEmpty()) {
                    eventQueue.wait()
                }
                eventQueue.removeAt(0)
            }
            threadPool.execute(event)
        }
    }
}

// Pushing events to queue
fun pushEvent(event: Runnable) {
    synchronized(eventQueue) {
        eventQueue.add(event)
        eventQueue.notifyAll()
    }
}

fun Any.wait() {
    val _this = this as Object
    synchronized(eventQueue) {
        while (eventQueue.isEmpty()) {
            _this.wait()
        }
    }
}

fun Any.notifyAll() {
    val _this = this as Object
    _this.notifyAll()
}