package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.experimental.TimeoutCancellationException

class N10CancellOnTimeout {
    @Test(expected = TimeoutCancellationException::class)
    fun testThrowTimeoutCancellationException() = runBlocking {
        val logger = StringBufferLogger()

        _10_cancell_on_timeout(logger)
    }

    @Test()
    fun testOutputAfterCancellation() = runBlocking {
        val logger = StringBufferLogger()

        try {
            _10_cancell_on_timeout(logger)
        } catch (e: TimeoutCancellationException) {
            assertEquals("....", logger.buffer.toString())
        }
    }
}