package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.concurrent.thread

const val delayMs = 500L

fun _n5_delayInThreads() {
    val threads = (1..10000).map {
        thread {
            Thread.sleep(delayMs)
        }
    }

    threads.map { it.join() }
}

suspend fun _n5_delayInCoroutines() {
    val jobs = (1..10000).map {
        launch {
            delay(delayMs)
        }
    }

    jobs.map { it.join() }
}