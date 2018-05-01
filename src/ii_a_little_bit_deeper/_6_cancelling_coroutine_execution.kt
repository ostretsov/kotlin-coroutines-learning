package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

suspend fun _n6_cancelling_corourine() {
    val job: Job = launch {
        repeat(1000) {
            delay(500)
            println(".")
        }
    }

    delay(1300)
    job.cancel()
    println("Job cancelled!")
}