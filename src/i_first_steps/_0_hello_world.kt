package i_first_steps

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Start")

    launch {
        delay(1000)
        println("Hello")
    }

    Thread.sleep(2000)
    println("Stop")
}