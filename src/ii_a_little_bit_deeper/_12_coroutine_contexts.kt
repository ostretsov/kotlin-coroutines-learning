package ii_a_little_bit_deeper

import Logger
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.coroutineContext

suspend fun _12_coroutine_context(logger: Logger) {
    val jobs = arrayListOf<Job>()
    jobs += launch(Unconfined) {
        logger.logln("Unconfined context: ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) {
        logger.logln("Coroutine context: ${Thread.currentThread().name}")
    }
    jobs += launch(CommonPool) {
        logger.logln("Common pool: ${Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("my_thread")) {
        logger.logln("Single thread: ${Thread.currentThread().name}")
    }

    jobs.forEach { it.join() }
}