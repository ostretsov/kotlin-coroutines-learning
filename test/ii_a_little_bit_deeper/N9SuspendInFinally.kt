package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlin.system.measureTimeMillis

class N9SuspendInFinally {
    @Test fun testSuspendInFinally() = runBlocking {
        val logger = StringBufferLogger()

        _9_suspend_in_finally(logger)

        assertEquals("..x!", logger.buffer.toString())
    }

    @Test fun testDoNotSuspendInFinally() = runBlocking {
        val logger = StringBufferLogger()

        _9_do_not_suspend_in_finally(logger)

        assertEquals("..x", logger.buffer.toString())
    }

    @Test fun testSuspendInFinallyTakes1700Ms() = runBlocking {
        val logger = StringBufferLogger()

        val takesMs = measureTimeMillis {
            _9_suspend_in_finally(logger)
        }

        assertTrue(takesMs >= 1700)
    }

    @Test fun testDoNotSuspendInFinallyTakesLessThan1700Ms() = runBlocking {
        val logger = StringBufferLogger()

        val takesMs = measureTimeMillis {
            _9_do_not_suspend_in_finally(logger)
        }

        assertTrue(takesMs < 1700)
    }
}