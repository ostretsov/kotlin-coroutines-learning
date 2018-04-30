package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert.*
import org.junit.Test
import kotlin.system.measureTimeMillis

class N4FirstCoroutinesTestTest {
    @Test fun testReturnValue() = runBlocking {
        assertEquals("Done!", _4_justDelay500())
    }

    @Test fun testDelayNoLessThan500ms() = runBlocking {
        val delay = measureTimeMillis {
            _4_justDelay500()
        }

        assertTrue(delay > 500)
    }
}