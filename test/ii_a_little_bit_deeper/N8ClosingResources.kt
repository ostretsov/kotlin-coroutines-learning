package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertEquals

class N8ClosingResources {
    @Test
    fun testFinallyKeyword() = runBlocking {
        val logger = StringBufferLogger()

        _8_closing_resources(logger)

        assertEquals("..x!", logger.buffer.toString())
    }
}