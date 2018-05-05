package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertTrue

class N15IterOverChannelTest {
    @Test
    fun testIterOverCh() = runBlocking {
        val logger = StringBufferLogger()

        _15_iter_over_channel(logger)

        val output = logger.buffer.toString()
        assertTrue(output.contains("1"))
        assertTrue(output.contains("4"))
        assertTrue(output.contains("9"))
        assertTrue(output.contains("16"))
        assertTrue(output.contains("25"))
    }
}