package ii_a_little_bit_deeper

import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.runBlocking

class N16ProducerConsumerTest {
    @Test
    fun testProducerConsumer() = runBlocking {
        val logger = StringBufferLogger()
        val ch = _16_producer()

        _16_consumer(ch, logger)

        assertTrue(logger.buffer.toString().contains("100"))
    }
}