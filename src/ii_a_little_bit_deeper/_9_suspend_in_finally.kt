package ii_a_little_bit_deeper

import Logger
import kotlinx.coroutines.experimental.*

suspend fun _9_suspend_in_finally(logger: Logger) {
    val job = launch {
        try {
            repeat(1000) {
                delay(500)
                logger.log(".")
            }
        } finally {
            withContext(NonCancellable) {
                delay(500)
                logger.log("!")
            }
        }
    }
    delay(1200)
    logger.log("x")
    job.cancelAndJoin()
}

suspend fun _9_do_not_suspend_in_finally(logger: Logger) {
    val job = launch {
        try {
            repeat(1000) {
                delay(500)
                logger.log(".")
            }
        } finally {
            delay(500)
            logger.log("!")
        }
    }
    delay(1200)
    logger.log("x")
    job.cancelAndJoin()
}