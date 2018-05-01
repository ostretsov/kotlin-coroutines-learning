package ii_a_little_bit_deeper

import StringBufferLogger
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class N6CancellingCoroutineExecutionTest {
    var logger = StringBufferLogger()

    @Test fun testJobCancellation() = runBlocking {
        _n6_cancelling_corourine(logger)

        assertEquals("..Job cancelled!", logger.buffer.toString())
    }
}