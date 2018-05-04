package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.launch
import Logger
import kotlinx.coroutines.experimental.delay

suspend fun _14_parent_cancells_child(logger: Logger) {
    val job = launch {
        val sj1 = launch {
            logger.logln("sub job 1 is starting")
            delay(1000)
            logger.logln("sub job 1 is finishing")
        }
        val sj2 = launch(coroutineContext) {
            logger.logln("sub job 2 is starting")
            delay(1000)
            logger.logln("sub job 2 is finishing")
        }

        sj1.join()
        sj2.join()
    }
    delay(500)
    job.cancel()
    delay(600)
}