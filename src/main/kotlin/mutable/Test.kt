package mutable

import java.util.LinkedList
import java.util.Queue
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class EventLoop {

    //    val threadsGroup = Executors.newFixedThreadPool(10)
    val dispatcher: Dispatch = Dispatch()
    val queue = LinkedList<Runnable>()

    fun handleEvent() {
        while (!Thread.currentThread().isInterrupted) {
            Thread.sleep(20)
            if (queue.isNotEmpty()) {
                val task = queue.poll()
                dispatcher.start(task)
            }
        }
    }

    fun fetchEvent(event: Runnable) {
        queue.add(event)
    }
}

//fun main() {
//    val eventLoop = EventLoop()
//    val mainLoop = thread {
//        eventLoop.handleEvent()
//    }
//
//    Thread.sleep(1000)
//    eventLoop.fetchEvent(Runnable {
//        println(Thread.currentThread().id)
//        println("Hello")
//    })
//
//    Thread.sleep(1000)
//    eventLoop.fetchEvent(Runnable {
//        println(Thread.currentThread().id)
//        println("World")
//    })
//
//    Thread.sleep(1000)
//    eventLoop.fetchEvent(Runnable {
//        println(Thread.currentThread().id)
//        println("!")
//    })
//
//    mainLoop.join()
//}

class Dispatch {
    val threadsGroup = Executors.newFixedThreadPool(10)

    fun start(task: Runnable) {
        threadsGroup.execute(task)
    }
}

fun a() {
    b()
    println("a")
}

fun b() {
    println("b")
}

class CoroutineTask(
    private val dispatcher: Dispatch,
    private val continuation: Continuation,
    private val block: (Continuation) -> Unit,
): Runnable {

    var task: Task? = null

    init {
        task = Task(block)
    }

    override fun run() {
        while (!Thread.currentThread().isInterrupted) {
            Thread.sleep(5)
            task!!.run(continuation)
        }
    }

    fun start() {
        dispatcher.start(this)
    }
}

class Task internal constructor(
    val run: (Continuation) -> Unit,
)


class Continuation(
    var step: Int = 0,
    private var localVariableArea: MutableMap<Any?, Any?> = mutableMapOf()
) {
    fun setLocalVariable(key: Any?, value: Any?) {
        localVariableArea[key] = value
    }

    fun getLocalVariable(key: Any?): Any? {
        return localVariableArea[key]
    }

    fun resume() {
        step++
    }
}

fun ab(eventLoop: EventLoop) {
    eventLoop.fetchEvent {
        println("b")
    }
    eventLoop.fetchEvent {
        println("a")
    }
}

fun main() {
    val continuationTask = CoroutineTask(Dispatch(), Continuation()) {
        it.setLocalVariable("a", 1)
        it.setLocalVariable("b", 3)
        when (it.step) {
            0 -> {
                println("a")
                it.resume()
            }
            1 -> {
                println("b")
                it.resume()
            }
        }
    }

    continuationTask.start()
}