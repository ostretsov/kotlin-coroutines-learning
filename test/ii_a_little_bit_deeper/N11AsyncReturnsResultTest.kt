package ii_a_little_bit_deeper

import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import kotlin.system.measureTimeMillis

class N11AsyncReturnsResultTest {
    @Test
    fun testSyncExecutionTakes1000Ms() = runBlocking {
        val takesMs = measureTimeMillis {
            _11_calcSthImportant1()
            _11_calcSthImportant2()
        }

        assertTrue(takesMs >= 1000)
    }

    @Test
    fun testAsyncExecutionTakesLessThan1000Ms() = runBlocking {
        val takesMs = measureTimeMillis {
            val x = async { _11_calcSthImportant1() }
            val y = async { _11_calcSthImportant2() }

            x.await() + y.await()
        }

        assertTrue(500 < takesMs && takesMs < 1000)
    }
}