package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.launch
import Logger
import kotlinx.coroutines.experimental.delay
import kotlin.coroutines.experimental.coroutineContext

suspend fun _13_unconfined_vs_confined(logger: Logger) {
    val jobs = arrayListOf<Job>()
    jobs += launch (Unconfined) {
        logger.logln("Unconfined, before: ${Thread.currentThread().name}")
        delay(100)
        logger.logln("Unconfined, after: ${Thread.currentThread().name}")
    }
    jobs += launch (coroutineContext) {
        logger.logln("Coroutine context, before: ${Thread.currentThread().name}")
        delay(100)
        logger.logln("Coroutine context, after: ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }
}