package i_first_steps

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    println("Start")

    launch {
        delay(1000)
        println("Hello")
    }

    runBlocking {
        delay(2000)
    }
    println("Stop")
}