package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertTrue

class N14ParentCancellsChild {
    @Test
    fun testParentCancellsChild() = runBlocking {
        val logger = StringBufferLogger()

        _14_parent_cancells_child(logger)

        assertTrue(logger.buffer.toString().contains("sub job 1 is starting"))
        assertTrue(logger.buffer.toString().contains("sub job 2 is starting"))
        assertTrue(logger.buffer.toString().contains("sub job 1 is finishing"))
    }
}