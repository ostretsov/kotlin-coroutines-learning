package ii_a_little_bit_deeper

import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.experimental.runBlocking

class N13UnconfinedVsConfinedTest {
    @Test
    fun testTwoContexts() = runBlocking {
        val logger = StringBufferLogger()

        _13_unconfined_vs_confined(logger)

        assertTrue(logger.buffer.toString().contains("Unconfined, before: main"))
        assertTrue(logger.buffer.toString().contains("Unconfined, after: kotlinx.coroutines.DefaultExecutor"))
        assertTrue(logger.buffer.toString().contains("Coroutine context, before: main"))
        assertTrue(logger.buffer.toString().contains("Coroutine context, after: main"))
    }
}