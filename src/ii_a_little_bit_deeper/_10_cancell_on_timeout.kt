package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.withTimeout
import Logger
import kotlinx.coroutines.experimental.delay

suspend fun _10_cancell_on_timeout(logger: Logger) {
    withTimeout(500L) {
        repeat(1000, {
            delay(100)
            logger.log(".")
        })
    }
}