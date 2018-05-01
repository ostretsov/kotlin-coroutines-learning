package ii_a_little_bit_deeper

import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.experimental.runBlocking

class N7CooperativeCancellation {
    val logger = StringBufferLogger()

    @Test fun testCooperativeCancellation() = runBlocking {
        _7_cooperative_cancellation(logger)

        assertEquals("xxxxx", logger.buffer.toString())
    }

    @Test fun testCheckingIfActive() = runBlocking {
        _7_checking_if_active(logger)

        assertEquals("xxx", logger.buffer.toString())
    }
}