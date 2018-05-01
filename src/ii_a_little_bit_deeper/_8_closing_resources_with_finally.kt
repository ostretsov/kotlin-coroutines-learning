package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.launch
import Logger
import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay

suspend fun _8_closing_resources(logger: Logger) {
    val job = launch {
        try {
            repeat(1000) {
                delay(500)
                logger.log(".")
            }
        } finally {
            logger.log("!")
        }
    }
    delay(1200)
    logger.log("x")
    job.cancelAndJoin()
}