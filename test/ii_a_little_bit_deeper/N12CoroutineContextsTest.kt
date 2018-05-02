package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import StringBufferLogger
import junit.framework.TestCase.assertTrue

class N12CoroutineContextsTest {
    @Test
    fun testDifferentCoroutineContexts() = runBlocking {
        val logger = StringBufferLogger()

        _12_coroutine_context(logger)

        assertTrue(logger.buffer.toString().contains("Unconfined context: main"))
        assertTrue(logger.buffer.toString().contains("Common pool: ForkJoinPool.commonPool-worker-1"))
        assertTrue(logger.buffer.toString().contains("Single thread: my_thread"))
        assertTrue(logger.buffer.toString().contains("Coroutine context: main"))
    }
}