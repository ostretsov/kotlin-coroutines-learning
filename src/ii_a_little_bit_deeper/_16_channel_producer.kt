package ii_a_little_bit_deeper

import Logger
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce

fun _16_producer() = produce<Int> {
    for(x in 1..100) {
        send(x)
    }
}

suspend fun _16_consumer(ch: ReceiveChannel<Int>, logger: Logger) {
    ch.consumeEach { logger.logln(it.toString()) }
}