package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import Logger
import kotlinx.coroutines.experimental.delay

suspend fun _15_iter_over_channel(logger: Logger) {
    val ch = Channel<Int>()
    launch {
        (1..5).forEach { ch.send(it * it) }
        ch.close()
    }

    for (i in ch) {
        delay(100)
        logger.logln(i.toString())
    }
}