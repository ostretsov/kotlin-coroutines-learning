package ii_a_little_bit_deeper

import Logger
import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

suspend fun _7_cooperative_cancellation(logger: Logger) {
    val job = launch {
        var timeMark = System.currentTimeMillis()
        var i = 0
        while (i < 5) {
            if (timeMark <= System.currentTimeMillis()) {
                i++
                timeMark += 500L
                logger.log("x")
            }
        }
    }

    delay(1200)
    job.cancelAndJoin()
}

suspend fun _7_checking_if_active(logger: Logger) {
    val job = launch {
        var timeMark = System.currentTimeMillis()
        var i = 0
        while (isActive) {
            if (timeMark <= System.currentTimeMillis()) {
                i++
                timeMark += 500L
                logger.log("x")
            }
        }
    }

    delay(1200)
    job.cancelAndJoin()
}