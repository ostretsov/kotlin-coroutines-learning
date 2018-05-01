package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import Logger

suspend fun _n6_cancelling_corourine(logger: Logger) {
    val job: Job = launch {
        repeat(1000) {
            delay(500)
            logger.log(".")
        }
    }

    delay(1300)
    job.cancel()
    logger.log("Job cancelled!")
}