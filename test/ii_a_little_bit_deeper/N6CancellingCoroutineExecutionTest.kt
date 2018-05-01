package ii_a_little_bit_deeper

import StringBufferLogger
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class N6CancellingCoroutineExecutionTest {
    @Test fun testJobCancellation() = runBlocking {
        val logger = StringBufferLogger()

        _n6_cancelling_corourine(logger)

        val expected = """.
.
Job cancelled!
"""
        assertEquals(expected, logger.buffer.toString())
    }
}